package data

import domain.News
import model.NewsResponse

fun NewsResponse.toDomain(): List<News> =
   results.map { it.toDomain() }

fun News.toDomain() =
    News(
        id = id,
        title = title,
        description = description,
        image = image,
        link = link,
    )
