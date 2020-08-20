package com.andra.codechallenge_storage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long=2000 // make delaye 2 sec

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val sharedPreferences = getSharedPreferences(userData.SP_NAME, Context.MODE_PRIVATE)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        //using handler to handle the delay of splashscreen
        Handler().postDelayed({

            val contains = sharedPreferences.contains(userData.FIELD_USERNAME)

            if (!contains) {
                val editor = sharedPreferences.edit()

                editor.putString(userData.FIELD_USERNAME, "sabrina")
                editor.putString(userData.FIELD_PASSWORD, "binar123")
                editor.putString(userData.FIELD_EMAIL, "sabrina@binar.co.id")

                editor.apply()
            }

            //here to make a intent into the main activity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)

    }
}