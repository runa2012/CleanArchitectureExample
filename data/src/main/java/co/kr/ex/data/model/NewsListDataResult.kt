package co.kr.ex.data.model

import com.google.gson.annotations.SerializedName

data class NewsListDataResult(
    @SerializedName("status") val status : String = "",
    @SerializedName("totalResults") val totalResults : Int = 0,
    @SerializedName("articles") val articles : List<NewsData> = listOf()
)
