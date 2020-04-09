package com.brewhog.android.kotlinmvvm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.brewhog.android.kotlinmvvm.R
import com.brewhog.android.kotlinmvvm.databinding.ItemUserBinding
import com.brewhog.android.kotlinmvvm.db.repository.UserRepository
import com.brewhog.android.kotlinmvvm.model.User

class UserAdapter(val repository: UserRepository) : RecyclerView.Adapter<UserHolder>() {
    var userList: List<User> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val inflater = LayoutInflater.from(parent.context)
        val userBinding = DataBindingUtil.inflate<ItemUserBinding>(inflater,
            R.layout.item_user,
            parent,
            false)

        return UserHolder(userBinding,repository)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(userList[position])
    }
}