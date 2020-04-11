package com.brewhog.android.kotlinmvvm

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.brewhog.android.kotlinmvvm.adapters.UserAdapter
import com.brewhog.android.kotlinmvvm.databinding.ActivityMainBinding
import com.brewhog.android.kotlinmvvm.db.repository.UserRepository
import com.brewhog.android.kotlinmvvm.model.User
import com.brewhog.android.kotlinmvvm.viewmodel.UserViewModel
import com.brewhog.android.kotlinmvvm.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var repository = UserRepository(applicationContext)
        val viewModelFactory = ViewModelFactory(repository)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(UserViewModel::class.java)
        val adapter = UserAdapter(repository)
        val mainBinding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        mainBinding.adapter = adapter
        mainBinding.viewModel = viewModel
        viewModel.userList.observe(this, Observer<List<User>>{
            adapter.userList = it
        })

    }
}
