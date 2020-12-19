package com.example.roomdatabasedemo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/*Entity class, this will basically create a table with the defined parameters as columns
  with id as primary key
  this will also serve as the user class in which we will store our data to upload to database
 */

@Entity(tableName = "user_data")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val firstName:String,
    val lastName:String,
    val age:Int
)