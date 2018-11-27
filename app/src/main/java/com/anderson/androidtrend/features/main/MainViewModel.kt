package com.anderson.androidtrend.features.main

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anderson.androidtrend.model.Item
import com.anderson.androidtrend.utlis.Outcome
import com.anderson.androidtrend.utlis.toLiveData
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel @Inject constructor(repository : ProjectsRepository) : ViewModel(){

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    init {
        repository.fetchPosts()
    }

    val outcomeData: LiveData<Outcome<List<Item>>> by lazy {
        repository.fetchOutcomeData.toLiveData(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    fun onRetrieveStart(){
        loadingVisibility.value = View.VISIBLE
    }

    fun onRetrieveFinish(){
        loadingVisibility.value = View.GONE
    }
}