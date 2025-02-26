package com.example.appsorteio

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appsorteio.databinding.ActivityNumberBinding
import kotlin.random.Random

class NumberActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNumberBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        inicializarToolbar()

        binding.btnSortearNumero.setOnClickListener {
            verificar()
        }
    }

    private fun inicializarToolbar() {
        setSupportActionBar(binding.includeToolbarNumero.materialToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun verificar() {
        val minimo = binding.editValorMinimo.text.toString()
        val maximo = binding.editValorMaximo.text.toString()

        when {
            minimo == "" && maximo == "" -> Toast.makeText(this, "Insira o intervalo númerico!", Toast.LENGTH_SHORT).show()
            minimo == "" -> Toast.makeText(this, "Insira o valor mínimo!", Toast.LENGTH_SHORT).show()
            maximo == "" -> Toast.makeText(this, "Insira o valor máximo!", Toast.LENGTH_SHORT).show()
            else -> sortear()
        }
    }

    private fun sortear() {
        val valorMinimo = binding.editValorMinimo.text.toString().toLong()
        val valorMaximo = binding.editValorMaximo.text.toString().toLong() + 1
        val numeroSorteado = Random.nextLong(valorMinimo, valorMaximo).toString()
        binding.textResultado.text = numeroSorteado
    }
}