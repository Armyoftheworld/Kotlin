package com.army.kotlinapp.inject.module

import com.army.kotlinapp.BASE_URL
import com.army.kotlinapp.api.GithubService
import com.army.kotlinapp.data.source.DataManager
import com.army.kotlinapp.data.source.IDataSource
import com.army.kotlinapp.data.source.local.LocalDataSource
import com.army.kotlinapp.data.source.remote.RemoteDataSource
import com.army.kotlinapp.inject.Local
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Army on 2017/06/17.
 */
@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideGithubService(): GithubService {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL).build().create(GithubService::class.java)
    }

    @Singleton
    @Named("remote")//两种方式（1）
    @Provides
    fun provideRemote(githubService: GithubService): IDataSource {
        return RemoteDataSource(githubService)
    }

    @Singleton
    @Local//两种方式（2）
    @Provides
    fun provideLocal(): IDataSource {
        return LocalDataSource()
    }

    @Singleton
    @Provides
    fun provideDataManager(@Named("remote") remote: IDataSource, @Local local: IDataSource): DataManager {
        return DataManager(remote, local)
    }
}