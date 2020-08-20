package com.andra.codechallenge_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.andra.codechallenge_storage.databinding.ActivityGameBinding
import kotlinx.android.synthetic.main.activity_game.*


class GameActivity : AppCompatActivity() {

    var inputPlayer = ""
    var inputComp =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {
        }

        home.setOnClickListener {
            startActivity(Intent(this, HalamanMenu::class.java))
        }

        val binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun resetPlayer(){
            batuP.setBackgroundResource(0)
            kertasP.setBackgroundResource(0)
            guntingP.setBackgroundResource(0)
        }

        fun resetComp() {
            batuC.setBackgroundResource(0)
            kertasC.setBackgroundResource(0)
            guntingC.setBackgroundResource(0)
        }

        binding.home.setOnClickListener {
            finish()
        }

        binding.batuP.setOnClickListener {
            binding.batuP.setBackgroundResource(R.drawable.layer_select)
            resetComp()
            inputPlayer = "batu"
            val comp =(1..3).random()
            computer(comp)
            result(inputPlayer, inputComp)
            binding.batuP.setClickable(false)
            binding.kertasP.setClickable(false)
            binding.guntingP.setClickable(false)
        }

        binding.kertasP.setOnClickListener {
            binding.kertasP.setBackgroundResource(R.drawable.layer_select)
            resetComp()
            inputPlayer = "kertas"
            val comp =(1..3).random()
            computer(comp)
            result(inputPlayer, inputComp)
            binding.batuP.setClickable(false)
            binding.kertasP.setClickable(false)
            binding.guntingP.setClickable(false)
        }

        binding.guntingP.setOnClickListener {
            binding.guntingP.setBackgroundResource(R.drawable.layer_select)
            resetComp()
            inputPlayer = "gunting"
            val comp =(1..3).random()
            computer(comp)
            result(inputPlayer, inputComp)
            binding.batuP.setClickable(false)
            binding.kertasP.setClickable(false)
            binding.guntingP.setClickable(false)
        }

        binding.reset.setOnClickListener {
            binding.batuP.setClickable(true)
            binding.kertasP.setClickable(true)
            binding.guntingP.setClickable(true)
            binding.vs.setImageResource(R.drawable.vs)
            resetComp()
            resetPlayer()
        }
    }

    fun computer(comp: Int):String {
        when (comp){
            1 -> {
                batuC.setBackgroundResource(R.drawable.layer_select)
                inputComp = "batu"
            }
            2 -> {
                kertasC.setBackgroundResource(R.drawable.layer_select)
                inputComp = "kertas"
            }
            3 -> {
                guntingC.setBackgroundResource(R.drawable.layer_select)
                inputComp = "gunting"
            }

        }
        return inputComp
    }


    fun result (player: String, com: String){
        if (inputPlayer == "batu" && inputComp == "batu") {
            vs.setImageResource(R.drawable.draw)
            Log.d("Game", "Pemain dan Komputer memilih batu. Hasilnya seri.")

        } else if (inputPlayer == "batu" && inputComp == "kertas") {
            vs.setImageResource(R.drawable.commenang)
            Log.d("Game", "Pemain memilih batu, sementara Komputer memilih kertas. Hasilnya Komputer menang.")

        } else if (inputPlayer == "batu" && inputComp == "gunting") {
            vs.setImageResource(R.drawable.pemainmenang)
            Log.d("Game", "Pemain memilih batu, sementara Komputer memilih gunting. Hasilnya Pemain menang.")

        } else if (inputPlayer == "kertas" && inputComp == "batu") {
            vs.setImageResource(R.drawable.pemainmenang)
            Log.d("Game", "Pemain memilih kertas, sementara Komputer memilih batu. Hasilnya Pemain menang.")

        } else if (inputPlayer == "kertas" && inputComp == "kertas") {
            vs.setImageResource(R.drawable.draw)
            Log.d("Game", "Pemain dan Komputer memilih batu. Hasilnya seri.")

        } else if (inputPlayer == "kertas" && inputComp == "gunting") {
            vs.setImageResource(R.drawable.commenang)
            Log.d("Game", "Pemain memilih kertas, sementara Komputer memilih gunting. Hasilnya Komputer menang.")

        } else if (inputPlayer == "gunting" && inputComp == "batu") {
            vs.setImageResource(R.drawable.commenang)
            Log.d("Game", "Pemain memilih gunting, sementara Komputer memilih batu. Hasilnya Komputer menang.")

        } else if (inputPlayer == "gunting" && inputComp == "kertas") {
            vs.setImageResource(R.drawable.pemainmenang)
            Log.d("Game", "Pemain memilih gunting, sementara Komputer memilih kertas. Hasilnya Pemain menang.")

        } else if (inputPlayer == "gunting" && inputComp == "gunting") {
            vs.setImageResource(R.drawable.draw)
            Log.d("Game", "Pemain dan Komputer memilih gunting. Hasilnya seri.")
        }

    }


}