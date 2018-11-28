package com.anderson.androidtrend

import android.content.Context
import com.anderson.androidtrend.utlis.TestUtils
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

internal class MockServerDispatcher(private val context: Context) {

    internal inner class RequestDispatcher : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {

            val trendingAndroid = context.resources.assets.open("json/trending_android.json")
            val projects = TestUtils.readTextStream(trendingAndroid)

            val reposInfo = context.resources.assets.open("json/repos_info.json")
            val details = TestUtils.readTextStream(reposInfo)

            return when {
                request.path.contains("/search/repositories") ->
                    MockResponse()
                        .setResponseCode(200)
                        .setBody(projects)

                request.path.startsWith( "/repos") ->
                    MockResponse()
                        .setResponseCode(200)
                        .setBody(details)
                else -> MockResponse().setResponseCode(404)
            }
        }
    }
}