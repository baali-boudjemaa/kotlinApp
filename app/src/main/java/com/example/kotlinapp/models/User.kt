package com.example.kotlinapp.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(@PrimaryKey
                @ColumnInfo(name = "ids") val ids:Int, @ColumnInfo(name = "uid")  val uid:String, @ColumnInfo(name = "name")  val name:String, val password:String)