package com.brewhog.android.kotlinmvvm.model

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index("email", "password", unique = true)])
data class User (var email: String, var password: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    constructor(email: String, password: String, id:Int):this(email,password){
        this.id = id
    }

    fun isInputDataValid():Boolean{
        return !TextUtils.isEmpty(email) and
                Patterns.EMAIL_ADDRESS.matcher(email).matches() and
                (password.length > 5)
    }

}