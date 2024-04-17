package di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import presentation.NewsViewModel

actual fun viewModelModule() =  module {
    factoryOf(::NewsViewModel)
}