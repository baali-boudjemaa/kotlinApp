package com.example.kotlinapp.Injection.module

import com.example.kotlinapp.Network.APIs
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object  API{
    @Provides
    internal  fun  connect(): APIs {
     val client = OkHttpClient.Builder().build()

    return  Retrofit.Builder()
        .baseUrl("http://192.168.43.51:8082")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build().create(APIs::class.java);
}




}