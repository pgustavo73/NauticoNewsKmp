import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.koin.compose.KoinContext
import presentation.NewView
import theme.AppTheme

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    KoinContext {
        AppTheme {
            NewView()
        }
    }
}