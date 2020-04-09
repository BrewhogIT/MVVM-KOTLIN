package com.brewhog.android.kotlinmvvm.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.brewhog.android.kotlinmvvm.databinding.ItemUserBinding
import com.brewhog.android.kotlinmvvm.db.repository.UserRepository
import com.brewhog.android.kotlinmvvm.model.User

class UserHolder(val itemUserBinding: ItemUserBinding, var repository: UserRepository) :
    RecyclerView.ViewHolder(itemUserBinding.root), View.OnLongClickListener {
    var user : User? = null

    init {
        itemView.setOnLongClickListener(this)
    }

    fun bind(user: User){
        this.user = user
        itemUserBinding.user = user
    }

    override fun onLongClick(p0: View?): Boolean {
        repository.deleteUser(user!!)
        return false
    }
}