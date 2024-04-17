package di

import data.NetworkNewDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataSourceModule = module {
    singleOf(::NetworkNewDataSource)
}