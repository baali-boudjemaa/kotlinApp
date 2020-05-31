package com.example.kotlinapp.database


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlinapp.models.User

@Dao
interface UserDao {
    @get:Query("SELECT * FROM user")
    val all: List<User>

    @Insert
    fun insertAll(vararg users: User)
}