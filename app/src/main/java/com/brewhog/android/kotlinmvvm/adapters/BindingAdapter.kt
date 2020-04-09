package com.brewhog.android.kotlinmvvm.adapters

import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter

@BindingAdapter("app:toastMessageAdapter")
fun messageAdapter(view: View,text:CharSequence?){
    Toast.makeText(view.context,text,Toast.LENGTH_LONG).show()
}