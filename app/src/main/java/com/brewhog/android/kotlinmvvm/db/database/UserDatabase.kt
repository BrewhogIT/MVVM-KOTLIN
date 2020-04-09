package com.brewhog.android.kotlinmvvm.db.database

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.brewhog.android.kotlinmvvm.db.dao.UserDao
import com.brewhog.android.kotlinmvvm.model.User

@Database(entities = [User::class],version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getUserDao():UserDao

    companion object{
        private var instance : UserDatabase? = null

        fun getInstance(context : Context) : UserDatabase? {
            if (instance == null){
                instance = Room.databaseBuilder(context,UserDatabase::class.java,"user_database")
                    .addCallback(roomCallback)
                    .build()
            }

            return instance
        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                InitializeDatabase(instance).execute()
            }
        }

        class InitializeDatabase(userDatabase: UserDatabase?) : AsyncTask<Unit,Unit,Unit>(){
            private val userDao = userDatabase?.getUserDao()

            override fun doInBackground(vararg p0: Unit?) {
                userDao?.addUser(User("FirstUser@mail.ru","123456"))
                userDao?.addUser(User("SecondUser@mail.ru","123456"))
                userDao?.addUser(User("ThirdUser@mail.ru","123456"))
            }

        }

    }
}