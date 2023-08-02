package co.kr.cleanarchitectureexample.di

import co.kr.ex.data.api.NewsListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    val host_url = "https://newsapi.org"

    @Provides
    fun provideBaseUrl() = host_url

    @Singleton
    @Provides
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .connectTimeout(10 , TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10 , TimeUnit.SECONDS)
        .build()

    @Singleton
    @Provides
    fun provideRetrofit( okHttpClient: OkHttpClient ) : Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(provideBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsListService( retrofit: Retrofit ) : NewsListService = retrofit.create(NewsListService::class.java)

}