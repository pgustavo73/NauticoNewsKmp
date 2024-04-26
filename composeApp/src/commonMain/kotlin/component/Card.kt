package component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
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
    var count by rememberSaveable { mutableStateOf(0) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
            .border(BorderStroke(1.dp, AppColors.greenSuperLight), shape),
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
            Column(modifier = Modifier.padding(15.dp)) {
                Row {
                    Text(
                        news.title,
                        color = AppColors.White
                    )
                }
                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Text(
                        news.description, color = AppColors.White,
                        style = MaterialTheme.typography.body2
                    )
                }
                Row(
                    modifier = Modifier.fillMaxSize().padding(top = 13.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Open News", color = AppColors.greenLight,
                        fontWeight = FontWeight.Bold
                    )
                    Button(
                        onClick = {
                            count++
                            if (count == 2) count = 0
                        },
                        colors = ButtonDefaults.buttonColors(AppColors.Background),
                        modifier = Modifier.size(50.dp)
                            .clip(CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "share",
                            tint = when (count) {
                                0 -> {
                                    AppColors.White
                                }

                                1 -> {
                                    AppColors.greenLight
                                }

                                else -> {
                                    AppColors.White
                                }
                            }
                        )
                    }
                }
            }

        }
    }
}