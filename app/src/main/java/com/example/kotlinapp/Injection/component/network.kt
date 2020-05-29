package com.example.kotlinapp.Injection.component

import com.example.kotlinapp.Injection.module.API
import com.example.kotlinapp.viewmodel.MainViewModel
import dagger.Component

@Component(modules = [API::class])
interface network {
    fun inject(viewModel: MainViewModel)
}