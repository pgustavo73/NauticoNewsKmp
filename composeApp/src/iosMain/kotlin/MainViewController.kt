import androidx.compose.ui.window.ComposeUIViewController
import di.dataSourceModule
import di.netWorkModule
import di.repositoryModule
import di.viewModelModule
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController { App() }

fun initKoin() {
    startKoin {
        modules(netWorkModule, dataSourceModule, repositoryModule, viewModelModule())
    }

}