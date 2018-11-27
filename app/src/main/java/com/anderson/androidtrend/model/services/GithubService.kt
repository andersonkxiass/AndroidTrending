package com.anderson.androidtrend.model.services

import com.anderson.androidtrend.model.Owner
import com.anderson.androidtrend.model.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("search/repositories")
    fun getRepositories(@Query("q", encoded = true) query: String,
                        @Query("sort") sort: String,
                        @Query("order") order: String,
                        @Query("per_page") perPage: Int): Observable<Response>

    @GET("repos/{owner}/{project}/contributors")
    fun getContributors(@Path("owner") owner: String,
                        @Path("project") project: String) : Observable<List<Owner>>
}