package model

import domain.News
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val results: List<News>
)
