package com.andra.codechallenge_storage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) { }

        viewPagerMain.adapter = MyPagerAdapter (supportFragmentManager)

    }
}