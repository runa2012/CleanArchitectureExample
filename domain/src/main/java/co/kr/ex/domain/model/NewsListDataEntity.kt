package co.kr.ex.domain.model

data class NewsListDataEntity(
    val status : String ,
    val totalResults : Int ,
    val articles : List<NewsDataEntity>
)