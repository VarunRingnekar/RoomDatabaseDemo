package com.example.roomdatabasedemo.data

import androidx.lifecycle.LiveData

/*
Connecting channel between database and UserViewModel
all the database functions are called by the view model through this repository
 */

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user:User){
        userDao.addUser(user)
    }
}