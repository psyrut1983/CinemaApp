package com.example.cinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {




        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
val registerButton = findViewById<Button>(R.id.main_activity_registration_button)
        val loginText = findViewById<TextView>(R.id.main_activity_login_text)

        registerButton.setOnClickListener {
            val intentToRegistrationActivity = Intent(this, RegistrationActivity::class.java)
            startActivity(intentToRegistrationActivity)

        }

     loginText.setOnClickListener {
         val intentToLoginActivity = Intent(this, LoginActivity::class.java)
         startActivity(intentToLoginActivity)


     }



    }





}