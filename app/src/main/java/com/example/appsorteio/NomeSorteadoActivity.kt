package com.example.appsorteio

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NomeSorteadoActivity : AppCompatActivity() {
    private lateinit var nomeSorteado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nome_sorteado)

        val nome = intent.getStringExtra("nome")
        val nomeSorteado: TextView = findViewById(R.id.text_nome_sorteado)

        nomeSorteado.text = nome
    }
}