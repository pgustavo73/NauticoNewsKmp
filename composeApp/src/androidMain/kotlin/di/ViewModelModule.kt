package di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module
import presentation.NewsViewModel

actual fun viewModelModule(): Module = module {
    viewModelOf(::NewsViewModel)
}