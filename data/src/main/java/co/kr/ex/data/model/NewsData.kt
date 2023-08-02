package co.kr.ex.data.model

import com.google.gson.annotations.SerializedName

data class NewsData(
    @SerializedName("author") val author : String? ,
    @SerializedName("title") val title : String? ,
    @SerializedName("description") val description : String?
)