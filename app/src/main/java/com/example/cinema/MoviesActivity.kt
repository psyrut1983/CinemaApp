package com.example.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.internal.ContextUtils.getActivity

class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)




    }
    override fun onBackPressed() {
        Log.d("backPressed","The Back Button is Pressed")
        finishAffinity()
        System.exit(0)
    }

}