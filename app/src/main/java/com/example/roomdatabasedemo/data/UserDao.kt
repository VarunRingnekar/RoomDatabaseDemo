package com.example.roomdatabasedemo.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/*
Interface class to define the functions to be carried out on the database
the annotation is the sql query that is run when the command following it is called
eg. adduser runs the Insert query
 */

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_data ORDER BY id ASC")
    fun readAllData() : LiveData<List<User>>
}