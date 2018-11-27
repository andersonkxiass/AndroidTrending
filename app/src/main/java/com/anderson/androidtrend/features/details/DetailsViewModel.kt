package com.anderson.androidtrend.features.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.anderson.androidtrend.model.Owner
import com.anderson.androidtrend.utlis.Outcome
import com.anderson.androidtrend.utlis.toLiveData
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DetailsViewModel @Inject constructor(private val repository : DetailsRepository ) : ViewModel(){

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val outcomeData: LiveData<Outcome<List<Owner>>> by lazy {
        repository.fetchOutcomeData.toLiveData(compositeDisposable)
    }

    fun getDetails(login : String,  name : String){
        repository.fetchData(login, name)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}