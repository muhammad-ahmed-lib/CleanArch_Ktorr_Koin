package com.example.insta.ktorcompose.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast


fun Context.showToast(message:String,duration: Int =Toast.LENGTH_SHORT){
    Toast.makeText(this,message,duration).show()
}
fun Context.newScreen(c:Class<*>,isFinish:Boolean=false){
    val context =this as Activity
    startActivity(Intent(this,c))
    if (isFinish) context.finish()
}