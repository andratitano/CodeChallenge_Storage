package com.andra.codechallenge_storage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val sharedPreferences = getSharedPreferences(userData.SP_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val username = sharedPreferences.getString(userData.FIELD_USERNAME, "Belum Ada Data")
        val email = sharedPreferences.getString(userData.FIELD_EMAIL, "Belum Ada Data")

        etEmail.setText(email)
        etUsername.setText(username)

        etEmail.addTextChangedListener(object : TextWatcher {
            var emailChange = ""
            override fun afterTextChanged(p0: Editable?) {
                editor.putString(userData.FIELD_EMAIL, emailChange)
                editor.apply()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                emailChange = etEmail.text.toString()
            }
        })

        etUsername.addTextChangedListener(object : TextWatcher {
            var usernameChange = ""
            override fun afterTextChanged(p0: Editable?) {
                editor.putString(userData.FIELD_USERNAME, usernameChange)
                editor.apply()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                usernameChange = etUsername.text.toString()
            }
        })

        fabAddMemo.setOnClickListener {

        }
    }
}