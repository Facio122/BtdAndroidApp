package com.example.btdapplication

import com.example.btdapplication.data.ApiService
import com.example.btdapplication.domain.GetGeneralInfoDataUseCase
import com.example.btdapplication.domain.GetOrdersDataUseCase
import com.example.btdapplication.domain.NetworkRepository
import com.example.btdapplication.domain.NetworkRepositoryImpl
import com.example.btdapplication.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<ApiService> { RetrofitClient.api }
    single<NetworkRepository> { NetworkRepositoryImpl(apiService = get()) }

    factory { GetOrdersDataUseCase(get()) }
    factory { GetGeneralInfoDataUseCase(get()) }


    viewModel { MainViewModel(get(), get()) }
}