package com.brewhog.android.kotlinmvvm.db.repository

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.brewhog.android.kotlinmvvm.db.dao.UserDao
import com.brewhog.android.kotlinmvvm.db.database.UserDatabase
import com.brewhog.android.kotlinmvvm.model.User

class UserRepository(context: Context) {
    private var userDao : UserDao

    init {
        val userDatabase = UserDatabase.getInstance(context)!!
        userDao = userDatabase.getUserDao()
    }

    fun getAllUsers():LiveData<List<User>>{
        return GetUsersAsync(userDao).execute().get()
    }

    fun addUser(user: User){
        AddUserAsync(userDao).execute(user)
    }

    fun deleteUser(user: User){
        DeleteUserAsync(userDao).execute(user)
    }

    fun updateUserInfo(user: User){
        UpdateUserAsync(userDao).execute(user)
    }

    companion object{
        private class GetUsersAsync(val userDao: UserDao) : AsyncTask<Unit, Unit, LiveData<List<User>>>() {
            override fun doInBackground(vararg p0: Unit?): LiveData<List<User>> {
                return userDao.getAllUsers()
            }
        }

        private class AddUserAsync(val userDao: UserDao) : AsyncTask<User,Unit,Unit>(){
            override fun doInBackground(vararg p0: User?) {
                userDao.addUser(p0[0]!!)
            }
        }

        private class DeleteUserAsync(val userDao: UserDao) : AsyncTask<User,Unit,Unit>(){
            override fun doInBackground(vararg p0: User?) {
                userDao.deleteUser(p0[0]!!)
            }
        }

        private class UpdateUserAsync(val userDao: UserDao) : AsyncTask<User,Unit,Unit>(){
            override fun doInBackground(vararg p0: User?) {
                userDao.updateUserInfo(p0[0]!!)
            }
        }
    }
}