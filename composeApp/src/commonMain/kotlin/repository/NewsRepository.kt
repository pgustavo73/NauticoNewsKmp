package repository

import model.BaseResult
import domain.News

interface NewsRepository {
    suspend fun getNews(): BaseResult<List<News>>
}