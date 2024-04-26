package presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import component.CardNews
import org.koin.compose.koinInject
import theme.AppColors


@Composable
fun NewView(viewModel: NewsViewModel = koinInject()) {

    val uiState by viewModel.stateUI.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        if (uiState.loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .width(70.dp)
                    .align(Alignment.Center),
                color = AppColors.greenSuperLight
            )
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(uiState.news) { news ->
                    CardNews(news = news)
                }
            }
        }
    }
}