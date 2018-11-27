package com.anderson.androidtrend.di.modules

import com.anderson.androidtrend.features.details.DetailsRepository
import com.anderson.androidtrend.features.main.ProjectsRepository
import com.anderson.androidtrend.model.services.GithubService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

@Module(includes = [ViewModelModule::class])
object AppModule {
    private const val BASE_URL = "https://api.github.com/"

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideGithubApi(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideMainRepository(githubService: GithubService): DetailsRepository {
        return DetailsRepository(githubService)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideProjectsRepository(githubService: GithubService): ProjectsRepository {
        return ProjectsRepository(githubService)
    }
}