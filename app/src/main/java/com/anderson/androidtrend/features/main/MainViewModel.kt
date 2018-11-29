package com.anderson.androidtrend.features.main

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anderson.androidtrend.model.Item
import com.anderson.androidtrend.utlis.Outcome
import com.anderson.androidtrend.utlis.Result
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainViewModel @Inject constructor(private val repository : ProjectsRepository) : ViewModel(){

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val networkFailureVisibility: MutableLiveData<Int> = MutableLiveData()
    val outcomeData : MutableLiveData<Outcome<List<Item>>> = MutableLiveData()
    private lateinit var subscribe :  Disposable

    init {
        executeRequest()
    }

    private fun executeRequest() {
        subscribe = repository.fetchData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { Result.fromData(it) }
            .onErrorResumeNext(Function { Observable.just(Result.fromError(it)) })
            .doOnSubscribe {

                loadingVisibility.postValue(View.VISIBLE)
                networkFailureVisibility.postValue(View.GONE)
            }
            .subscribe({ result ->

                loadingVisibility.postValue(View.GONE)
                networkFailureVisibility.postValue(View.GONE)

                outcomeData.postValue(Outcome.success(result.data?.items!!))

            }, { error ->
                loadingVisibility.postValue(View.GONE)
                networkFailureVisibility.postValue(View.VISIBLE)

                outcomeData.postValue(Outcome.failure(error))
            })
    }

    fun tryItOut(){
        executeRequest()
    }

    override fun onCleared() {
        subscribe.dispose()
        super.onCleared()
    }
}