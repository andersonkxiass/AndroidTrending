package com.anderson.androidtrend.features.main

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anderson.androidtrend.model.Item
import com.anderson.androidtrend.utlis.Outcome
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(repository : ProjectsRepository) : ViewModel(){

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val outcomeData : MutableLiveData<Outcome<List<Item>>> = MutableLiveData()
    private var subscribe :  Disposable

    init {

         subscribe = repository.fetchData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                loadingVisibility.postValue(View.VISIBLE)
            }
            .subscribe({ result ->
                loadingVisibility.postValue(View.GONE)
                outcomeData.postValue(Outcome.success(result.items!!))
            }, { error ->
                loadingVisibility.postValue(View.GONE)
                outcomeData.postValue(Outcome.failure(error))
            })
    }

    override fun onCleared() {
        subscribe.dispose()
        super.onCleared()
    }
}