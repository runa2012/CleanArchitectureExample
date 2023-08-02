package co.kr.ex.data

import co.kr.ex.data.api.NewsListService
import co.kr.ex.domain.model.NewsDataEntity
import co.kr.ex.domain.model.NewsListDataEntity
import co.kr.ex.domain.repository.NewsListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsLIstRepositoryImpl @Inject constructor(
    private val newsListService: NewsListService
)  : NewsListRepository {

    override suspend fun getList( country : String , apiKey : String ): Flow<NewsListDataEntity> {
        return flow {
            val temp = newsListService.getNewsList( country, apiKey )
            val data = NewsListDataEntity (
                temp.status,
                temp.totalResults,
                temp.articles.map {
                    NewsDataEntity(
                        it.author,
                        it.title,
                        it.description
                    )
                }
            )
            emit(data)
        }
    }

}