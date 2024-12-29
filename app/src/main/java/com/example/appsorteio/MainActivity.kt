package com.example.appsorteio

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var editResultado: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sortear(view: View) {
        editResultado = findViewById(R.id.edit_valor)
        val valor = editResultado.text.toString().toLong() + 1
        val textoResultado = findViewById<TextView>(R.id.text_resultado)
        val numeroSorteado = Random.nextLong(1, valor).toString()
        textoResultado.setText(numeroSorteado)
    }
}