package com.example.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.`activity_movies`)




    }
    override fun onBackPressed() {
        finishAffinity()
        System.exit(0)
    }

}