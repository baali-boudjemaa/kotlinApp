package com.example.kotlinapp.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "UserClass")
data class User(@PrimaryKey
                @ColumnInfo(name = "id") val id:Int, @ColumnInfo(name = "uid")  val uid:String,@ColumnInfo(name = "name")  val name:String, val password:String)