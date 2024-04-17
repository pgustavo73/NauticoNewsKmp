package data

import domain.News
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class NetworkNewDataSource(private val client: HttpClient) {


suspend fun getNews(): List<News> {
        return withContext(Dispatchers.IO) {
                try {
                        val response: HttpResponse = client.get(NEWS_PATH)
                        when (response.status) {
                                HttpStatusCode.OK -> {
                                        val jsonString = response.bodyAsText()
                                        Json.decodeFromString<List<News>>(jsonString)
                                }
                                else -> throw Exception("Failed to fetch news: ${response.status}")
                        }
                } catch (e: Exception) {
                        println("Exception occurred while fetching news: $e")
                        throw e
                }
        }
}

}

