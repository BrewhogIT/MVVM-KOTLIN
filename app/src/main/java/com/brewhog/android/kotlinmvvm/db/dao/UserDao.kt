package com.brewhog.android.kotlinmvvm.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.brewhog.android.kotlinmvvm.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllUsers():LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: User)

    @Update
    fun updateUserInfo(user: User)

    @Delete
    fun deleteUser(user: User)
}