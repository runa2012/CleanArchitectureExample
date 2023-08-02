package co.kr.ex.data.api

import co.kr.ex.data.model.NewsListDataResult
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsListService  {

    @GET( "/v2/top-headlines")
    suspend fun getNewsList(
        @Query(value = "country") country : String ,
        @Query(value = "apiKey") apiKey : String
    ) : NewsListDataResult

}