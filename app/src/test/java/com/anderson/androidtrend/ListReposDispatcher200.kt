package com.anderson.androidtrend

import com.anderson.androidtrend.utlis.TestUtils
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class ListReposDispatcher200 {

    internal inner class RequestDispatcher : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {

            return when {
                request.path.contains("/search/repositories") ->
                    MockResponse()
                        .setResponseCode(200)
                        .setBody(TestUtils.getJson("/json/jvm_trending_android.json"))
                else -> MockResponse().setResponseCode(404)
            }
        }
    }
}