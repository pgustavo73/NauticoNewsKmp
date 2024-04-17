package component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import domain.News
import io.kamel.core.Resource
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import theme.AppColors

@Composable
fun CardNews(news: News) {
    val painterResource: Resource<Painter> = asyncPainterResource(news.image)
    val shape = RoundedCornerShape(10.dp)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(421.dp)
            .padding(8.dp)
            .border(BorderStroke(1.dp, Color.White), shape),
    ) {
        Column {
            Box {
                KamelImage(
                    painterResource,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(221.dp),
                    contentScale = ContentScale.Crop,
                    onLoading = { Text("Loading") },
                    onFailure = { Text("Error") }
                )
            }
            Box(modifier = Modifier.padding(15.dp)) {
                Text(
                    news.title,
                    color = AppColors.White
                )
                Text(
                    news.description, color = AppColors.White,
                    modifier = Modifier.padding(top = 30.dp),
                    style = MaterialTheme.typography.body2
                )
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.Bottom
                ) { Text("Open News", color = AppColors.White) }
            }

        }
    }
}

