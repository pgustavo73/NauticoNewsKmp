package di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import repository.NewRepositoryImp
import repository.NewsRepository


val repositoryModule = module {
    singleOf(::NewRepositoryImp){
        bind<NewsRepository>()
    }
}