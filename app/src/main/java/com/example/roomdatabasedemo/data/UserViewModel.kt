package com.example.roomdatabasedemo.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*
view model for the user class so that the data isn't handled in the UI controllers(eg. fragments)

 */

class UserViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }


    fun addUser(user: User){
        //using coroutines to run the code in worker thread
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}
