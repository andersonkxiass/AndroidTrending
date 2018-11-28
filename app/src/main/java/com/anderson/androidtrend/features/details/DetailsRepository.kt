package com.anderson.androidtrend.features.details

import com.anderson.androidtrend.model.Owner
import com.anderson.androidtrend.model.services.GithubService
import io.reactivex.Observable
import javax.inject.Inject

class DetailsRepository @Inject constructor(private var service : GithubService){

    fun fetchData( login : String,  name : String): Observable<List<Owner>> {
        return service.getContributors(login, name)
    }
}