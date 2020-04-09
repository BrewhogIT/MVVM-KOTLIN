package com.brewhog.android.kotlinmvvm.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.brewhog.android.kotlinmvvm.db.repository.UserRepository
import com.brewhog.android.kotlinmvvm.model.User

class UserViewModel(var repository: UserRepository) : ViewModel(){
    private var user = User("","")
    private val successMessage = "User was add successful"
    private val errorMessage = "Email or password not valid"
    var toastMessage = ObservableField<String>()
    var userList = repository.getAllUsers()

    fun afterEmailTextChange (text : CharSequence){
        user.email = text.toString()
    }

    fun afterPasswordChange (text: CharSequence){
        user.password = text.toString()
    }

    fun onAddClicked(){
        if (user.isInputDataValid()){
            toastMessage.set(successMessage)
            repository.addUser(user)
        }else{
            toastMessage.set(errorMessage)
        }
    }

}