package com.example.rxnumbersexample.presentation.di

import androidx.lifecycle.MutableLiveData
import com.example.rxnumbersexample.data.endpoints.MainApi
import com.example.rxnumbersexample.domain.useCases.MainUC
import com.example.rxnumbersexample.network.ManageNetwork
import com.example.rxnumbersexample.presentation.view.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val mainViewModel = module {
    viewModel {
        MainViewModel(
            get(),
            MutableLiveData()
        )
    }
}

val mainUC = module {
    factory {
        MainUC(listNumbers)
    }
}

private val retrofit: Retrofit = ManageNetwork().getInstance()

private val listNumbers: MainApi = retrofit.create(MainApi::class.java)