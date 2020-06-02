package com.example.kotlinapp.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinapp.models.User


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}