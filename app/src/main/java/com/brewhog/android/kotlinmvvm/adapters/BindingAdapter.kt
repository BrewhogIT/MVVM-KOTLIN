package com.brewhog.android.kotlinmvvm.adapters

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

@BindingAdapter("app:toastMessageAdapter")
fun messageAdapter(view: View,text:LiveData<String>?){
    text?.observe(view.context as LifecycleOwner, Observer {
        Toast.makeText(view.context,it,Toast.LENGTH_LONG).show()
    })

}