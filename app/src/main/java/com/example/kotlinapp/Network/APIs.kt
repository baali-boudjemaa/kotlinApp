package com.example.kotlinapp.Network

import com.example.kotlinapp.Model.User
import com.example.kotlinapp.Model.response
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIs {

    @GET("/AllUsers")
    fun getAllUsers(): Observable<List<User>>

}