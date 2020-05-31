package com.example.kotlinapp.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.kotlinapp.database.AppDatabase


class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "users").build()
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(db.userDao()) as T

        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}