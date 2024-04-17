package repository

import data.NetworkNewDataSource
import domain.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import model.BaseResult

class NewRepositoryImp(private val dataSource: NetworkNewDataSource) : NewsRepository {
    override suspend fun getNews(): BaseResult<List<News>> {
        return try {
            val news = withContext(Dispatchers.IO) {
                dataSource.getNews()
            }
            BaseResult.Success(news)
        } catch (e: Exception) {
            BaseResult.Error(e)
        }
    }
}