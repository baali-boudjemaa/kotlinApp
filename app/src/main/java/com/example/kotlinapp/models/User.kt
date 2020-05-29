package com.example.kotlinapp.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserClass")
data class User(@PrimaryKey
                @ColumnInfo(name = "id") val id:Int, @ColumnInfo(name = "uid")  val uid:String, @ColumnInfo(name = "name")  val name:String, val password:String)