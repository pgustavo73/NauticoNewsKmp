package di

import data.getNetworkClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val netWorkModule = module {
    singleOf(::getNetworkClient)
}