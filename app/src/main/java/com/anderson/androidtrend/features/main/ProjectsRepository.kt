package com.anderson.androidtrend.features.main

import com.anderson.androidtrend.model.Response
import com.anderson.androidtrend.model.services.GithubService
import io.reactivex.Observable
import javax.inject.Inject

class ProjectsRepository @Inject constructor(private var service : GithubService){

    private val query = "android+language:java,android+language:kotlin"
    private val sort = "stars"
    private val order = "desc"
    private val perPage = 25

    fun fetchData(): Observable<Response> {
        return service
            .getRepositories(query, sort, order, perPage)

    }
}