package com.example.appsorteio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var BtnNumero: Button
    private lateinit var BtnNome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BtnNumero = findViewById<Button>(R.id.btn_numero)
        BtnNome = findViewById<Button>(R.id.btn_nome)

        BtnNumero.setOnClickListener {
            startActivity(Intent(this, NumberActivity::class.java))
        }

        BtnNome.setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))
        }

    }
}