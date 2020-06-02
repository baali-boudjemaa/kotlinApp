package com.example.kotlinapp.Network

import com.example.kotlinapp.models.User
import com.example.kotlinapp.models.response
import io.reactivex.Observable
import retrofit2.http.GET

interface APIs {

    @GET("/AllUsers")
    fun getAllUsers(): Observable<response>

}