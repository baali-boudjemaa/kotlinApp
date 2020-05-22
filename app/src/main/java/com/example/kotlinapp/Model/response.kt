package com.example.kotlinapp.Model

import com.example.kotlinapp.Model.User
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class response (  val user: List<User>,val success: String)