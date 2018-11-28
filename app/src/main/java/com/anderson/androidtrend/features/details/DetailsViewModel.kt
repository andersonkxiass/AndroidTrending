package com.anderson.androidtrend.features.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anderson.androidtrend.model.Owner
import com.anderson.androidtrend.utlis.Outcome
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailsViewModel @Inject constructor(private val repository : DetailsRepository ) : ViewModel(){

    val outcomeData : MutableLiveData<Outcome<List<Owner>>> = MutableLiveData()
    lateinit var subscribe : Disposable

    fun getDetails(login : String,  name : String){
         subscribe = repository.fetchData(login, name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                outcomeData.postValue(Outcome.success(result))
            }, { error ->
                outcomeData.postValue(Outcome.failure(error))
            })
    }

    override fun onCleared() {

        subscribe.let {
            subscribe.dispose()
        }

        super.onCleared()
    }
}