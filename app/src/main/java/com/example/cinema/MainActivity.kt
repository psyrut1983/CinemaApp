package com.example.cinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private val signInLauncher = registerForActivityResult( //создали объект авторизации
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)  //запуск экрана
    }
    private lateinit var database: DatabaseReference

    val providers = arrayListOf(
        AuthUI.IdpConfig.EmailBuilder().build(),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Firebase.database.reference   //инциализация базы данных

        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        signInLauncher.launch(signInIntent)
    }
    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {
            // Successfully signed in
            val authuser = FirebaseAuth.getInstance().currentUser

            authuser?.let {
                val email = it.email.toString()
                val uid = it.uid
                val firebasUser = User(email, uid)
                database.child("users").child(uid).setValue(firebasUser)
                val intentToMoviesActivity = Intent(this, MoviesActivity::class.java)
                startActivity(intentToMoviesActivity)

            }



            // ...
        } else {
            Toast.makeText(this@MainActivity, "Something wrong with registration", Toast.LENGTH_LONG).show()
            // Sign in failed. If response is null the user canceled the
           

        }
    }




}