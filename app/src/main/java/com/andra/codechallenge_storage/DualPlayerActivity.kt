package com.andra.codechallenge_storage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andra.codechallenge_storage.databinding.ActivityGameBinding
import kotlinx.android.synthetic.main.activity_game.*

class DualPlayerActivity : AppCompatActivity() {
    lateinit var binding:ActivityGameBinding

    var inputPlayer = ""
    var inputComp =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)
        
        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {
        }

        home.setOnClickListener {
            startActivity(Intent(this, HalamanMenu::class.java))
        }

        val binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.home.setOnClickListener {
            finish()
        }

        binding.COM.setText("Pemain 2")

        //batu pemain
        binding.batuP.setOnClickListener {
            binding.batuP.setBackgroundResource(R.drawable.layer_select)
            inputPlayer = "batu"

            binding.batuP.setClickable(false)
            binding.kertasP.setClickable(false)
            binding.guntingP.setClickable(false)

            binding.batuC.setOnClickListener {
                inputComp = "batu"

                binding.batuC.setClickable(false)
                binding.kertasC.setClickable(false)
                binding.guntingC.setClickable(false)

                binding.batuC.setBackgroundResource(R.drawable.layer_select)
                binding.vs.setImageResource(R.drawable.draw)
            }

            binding.guntingC.setOnClickListener {
                inputComp = "gunting"

                binding.batuC.setClickable(false)
                binding.kertasC.setClickable(false)
                binding.guntingC.setClickable(false)

                binding.guntingC.setBackgroundResource(R.drawable.layer_select)
                binding.vs.setImageResource(R.drawable.pemainmenang)
            }

            binding.kertasC.setOnClickListener {
                inputComp = "kertas"

                binding.batuC.setClickable(false)
                binding.kertasC.setClickable(false)
                binding.guntingC.setClickable(false)

                binding.kertasC.setBackgroundResource(R.drawable.layer_select)
                binding.vs.setImageResource(R.drawable.lawanmenang)
            }
        }

        // gunting pemain
        binding.guntingP.setOnClickListener {
            binding.guntingP.setBackgroundResource(R.drawable.layer_select)
            inputPlayer = "gunting"

            binding.batuP.setClickable(false)
            binding.kertasP.setClickable(false)
            binding.guntingP.setClickable(false)

            binding.batuC.setOnClickListener {
                inputComp = "batu"

                binding.batuC.setClickable(false)
                binding.kertasC.setClickable(false)
                binding.guntingC.setClickable(false)

                binding.batuC.setBackgroundResource(R.drawable.layer_select)
                binding.vs.setImageResource(R.drawable.lawanmenang)
            }

            binding.guntingC.setOnClickListener {
                inputComp = "gunting"

                binding.batuC.setClickable(false)
                binding.kertasC.setClickable(false)
                binding.guntingC.setClickable(false)

                binding.guntingC.setBackgroundResource(R.drawable.layer_select)
                binding.vs.setImageResource(R.drawable.draw)
            }

            binding.kertasC.setOnClickListener {
                inputComp = "kertas"

                binding.batuC.setClickable(false)
                binding.kertasC.setClickable(false)
                binding.guntingC.setClickable(false)

                binding.kertasC.setBackgroundResource(R.drawable.layer_select)
                binding.vs.setImageResource(R.drawable.pemainmenang)
            }
        }

        //kertas pemain
        binding.kertasP.setOnClickListener {
            binding.kertasP.setBackgroundResource(R.drawable.layer_select)
            inputPlayer = "kertas"

            binding.batuP.setClickable(false)
            binding.kertasP.setClickable(false)
            binding.guntingP.setClickable(false)

            binding.batuC.setOnClickListener {
                inputComp = "batu"

                binding.batuC.setClickable(false)
                binding.kertasC.setClickable(false)
                binding.guntingC.setClickable(false)

                binding.batuC.setBackgroundResource(R.drawable.layer_select)
                binding.vs.setImageResource(R.drawable.pemainmenang)
            }

            binding.guntingC.setOnClickListener {
                inputComp = "gunting"

                binding.batuC.setClickable(false)
                binding.kertasC.setClickable(false)
                binding.guntingC.setClickable(false)

                binding.guntingC.setBackgroundResource(R.drawable.layer_select)
                binding.vs.setImageResource(R.drawable.lawanmenang)
            }

            binding.kertasC.setOnClickListener {
                inputComp = "kertas"

                binding.batuC.setClickable(false)
                binding.kertasC.setClickable(false)
                binding.guntingC.setClickable(false)

                binding.kertasC.setBackgroundResource(R.drawable.layer_select)
                binding.vs.setImageResource(R.drawable.draw)
            }
        }

        binding.reset.setOnClickListener {
            binding.batuP.setClickable(true)
            binding.kertasP.setClickable(true)
            binding.guntingP.setClickable(true)

            binding.batuP.setBackgroundResource(0)
            binding.kertasP.setBackgroundResource(0)
            binding.guntingP.setBackgroundResource(0)

            binding.batuC.setBackgroundResource(0)
            binding.kertasC.setBackgroundResource(0)
            binding.guntingC.setBackgroundResource(0)

            binding.vs.setImageResource(R.drawable.vs)
        }

    }
}