package com.example.appsorteio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appsorteio.databinding.ActivityNomeSorteadoBinding

class NomeSorteadoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNomeSorteadoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        inicializarToolbar()

        val nome = intent.getStringExtra("nome")
        binding.textNomeSorteado.text = nome
    }

    private fun inicializarToolbar() {
        setSupportActionBar(binding.includeToolbarSorteado.materialToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}