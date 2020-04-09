package com.brewhog.android.kotlinmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.brewhog.android.kotlinmvvm.adapters.UserAdapter
import com.brewhog.android.kotlinmvvm.databinding.ActivityMainBinding
import com.brewhog.android.kotlinmvvm.db.repository.UserRepository
import com.brewhog.android.kotlinmvvm.model.User
import com.brewhog.android.kotlinmvvm.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var repository = UserRepository(applicationContext)
        val viewModel = UserViewModel(repository)
        val adapter = UserAdapter(repository)
        val mainBinding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        mainBinding.adapter = adapter
        mainBinding.viewModel = viewModel
        viewModel.userList.observe(this, Observer<List<User>>{
            adapter.userList = it
        })

    }
}
