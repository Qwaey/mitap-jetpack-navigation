package com.example.jetpacknavigation.di

import com.example.jetpacknavigation.ui.base.SimpleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module(override = true) {

    viewModel { SimpleViewModel() }

}
