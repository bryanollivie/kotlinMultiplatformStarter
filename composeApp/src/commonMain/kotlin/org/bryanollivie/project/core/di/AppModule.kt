package org.bryanollivie.project.core.di

import org.bryanollivie.project.feature.login.LoginViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
/*
val dataModule = module {
    single<LoginRepository> {
        LoginRepositoryImpl()
    }
}*/
val viewModelModule = module {
    viewModel {
        LoginViewModel(
            //repository = get()
        )
    }
}
val appModule = listOf<Module>()

