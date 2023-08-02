package co.kr.ex.domain.repository

import co.kr.ex.domain.model.NewsListDataEntity
import kotlinx.coroutines.flow.Flow

interface NewsListRepository {

    suspend fun getList( country : String , apiKey : String) : Flow<NewsListDataEntity>

}