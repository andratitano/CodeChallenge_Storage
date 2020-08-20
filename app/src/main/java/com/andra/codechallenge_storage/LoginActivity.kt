package com.andra.codechallenge_storage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences(userData.SP_NAME, Context.MODE_PRIVATE)
        val usr = sharedPreferences.getString(userData.FIELD_USERNAME, "Belum Ada Data")
        val pass = sharedPreferences.getString(userData.FIELD_PASSWORD, "Belum Ada Data")

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            if (username == "" || password == ""){
                Snackbar.make(it, "Username dan Password harus terisi", Snackbar.LENGTH_LONG).show()
            } else if (username != usr || password != pass){
                Snackbar.make(it, "Username atau Password Salah", Snackbar.LENGTH_LONG).show()
            } else {
                startActivity(Intent(this,HalamanMenu::class.java))
                finish()
            }
        }

        btnReset.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()

            editor.putString(userData.FIELD_USERNAME, "sabrina")
            editor.putString(userData.FIELD_PASSWORD, "binar123")
            editor.putString(userData.FIELD_EMAIL, "sabrina@binar.co.id")

            editor.apply()

            Snackbar.make(it, "Username dan Password telah direset", Snackbar.LENGTH_LONG).show()
        }
    }
}