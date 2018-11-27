package com.anderson.androidtrend.features.main

import com.anderson.androidtrend.model.Item
import com.anderson.androidtrend.model.services.GithubService
import com.anderson.androidtrend.utlis.Outcome
import com.anderson.androidtrend.utlis.failed
import com.anderson.androidtrend.utlis.loading
import com.anderson.androidtrend.utlis.success
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class ProjectsRepository @Inject constructor(private var service : GithubService){

    private val query = "android+language:java,android+language:kotlin"
    private val sort = "stars"
    private val order = "desc"
    private val perPage = 25

    val fetchOutcomeData: PublishSubject<Outcome<List<Item>>> =
        PublishSubject.create<Outcome<List<Item>>>()

    fun fetchPosts() {
        service
            .getRepositories(query, sort, order, perPage)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                fetchOutcomeData.loading(true)
            }
            .doOnNext {
                fetchOutcomeData.loading(false)
            }
            .subscribe ({ result ->
                fetchOutcomeData.success(result.items!!)
            }, { error ->
                fetchOutcomeData.failed(error)
            })
    }
}