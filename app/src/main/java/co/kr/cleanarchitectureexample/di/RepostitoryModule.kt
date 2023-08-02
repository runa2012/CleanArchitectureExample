package co.kr.cleanarchitectureexample.di

import co.kr.ex.data.NewsLIstRepositoryImpl
import co.kr.ex.data.api.NewsListService
import co.kr.ex.domain.repository.NewsListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepostitoryModule  {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Provides
    fun provideNewsListRepository (
        newsListService: NewsListService
    ) : NewsListRepository = NewsLIstRepositoryImpl(newsListService)

}
