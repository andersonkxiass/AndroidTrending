package com.anderson.androidtrend.features.main

import com.anderson.androidtrend.ListReposDispatcher200
import com.anderson.androidtrend.model.Response
import com.anderson.androidtrend.model.services.GithubService
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

@RunWith(JUnit4::class)
class ProjectsRepositoryTest {

    lateinit var service: GithubService
    lateinit var projectsRepository: ProjectsRepository
    private val webServer : MockWebServer = MockWebServer()

    @Before
    fun setUp() {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:8080/")
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()

        service = retrofit.create(GithubService::class.java)

        projectsRepository = ProjectsRepository(service)

        webServer.start(8080)
    }

    @Test
    fun fetchData() {
        webServer.setDispatcher(ListReposDispatcher200().RequestDispatcher())

        val testObserver = TestObserver<Response>()

        projectsRepository.fetchData().subscribe(testObserver)

        testObserver.assertNoErrors()
    }

    @After
    fun tearDown() {
        webServer.shutdown()
    }
}