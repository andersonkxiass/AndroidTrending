package com.anderson.androidtrend.features.details

import com.anderson.androidtrend.model.Owner
import com.anderson.androidtrend.model.services.GithubService
import com.anderson.androidtrend.utlis.Outcome
import com.anderson.androidtrend.utlis.failed
import com.anderson.androidtrend.utlis.loading
import com.anderson.androidtrend.utlis.success
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class DetailsRepository @Inject constructor(private var service : GithubService){

    val fetchOutcomeData: PublishSubject<Outcome<List<Owner>>> =
        PublishSubject.create<Outcome<List<Owner>>>()

    fun fetchData( login : String,  name : String){

        service.getContributors(login, name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                fetchOutcomeData.loading(true)
            }
            .doOnNext {
                fetchOutcomeData.loading(false)
            }
            .subscribe ({ result ->
                fetchOutcomeData.success(result)
            }, { error ->
                fetchOutcomeData.failed(error)
            })
    }
}