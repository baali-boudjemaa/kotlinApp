package com.example.kotlinapp.Injection.component

import com.example.kotlinapp.Injection.module.NetworkModule
import com.example.kotlinapp.viewmodel.MainViewModel
import dagger.Component

@Component(modules = [NetworkModule::class])
interface ViewModelInjector {
    fun inject(viewModel: MainViewModel)
}