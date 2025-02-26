package com.example.appsorteio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appsorteio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        inicializarTollbar()

        binding.btnNumero.setOnClickListener {
            startActivity(Intent(this, NumberActivity::class.java))
        }

        binding.btnNome.setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))
        }
    }

    private fun inicializarTollbar() {
        setSupportActionBar(binding.includeToolbar.materialToolbarmMain)
    }
}