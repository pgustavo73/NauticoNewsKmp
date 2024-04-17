package presentation

import domain.News

data class NewStateUI(
    val news: List<News> = listOf(),
    val error: Exception? = null,
    val loading: Boolean = false
)
