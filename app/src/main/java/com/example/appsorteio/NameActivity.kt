package com.example.appsorteio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class NameActivity : AppCompatActivity() {
    private lateinit var btnAdicionar: Button
    private lateinit var btnRemover: Button
    private lateinit var adicionarNome : EditText
    private lateinit var removerNome: EditText
    private lateinit var rvLista: RecyclerView
    private lateinit var btnSortear: Button
    private lateinit var participante: ParticipanteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        //val lista = mutableListOf<String>()

        //InicializandoComponentes
        btnAdicionar = findViewById(R.id.btn_adicionar)
        adicionarNome = findViewById(R.id.adicionar_nome)
        rvLista = findViewById(R.id.rv_lista)
        btnSortear = findViewById(R.id.btn_sorteio)

        // Inicialização do Adapter e configuração do RecyclerView
        participante = ParticipanteAdapter()
        rvLista.adapter = participante
        rvLista.layoutManager = LinearLayoutManager(this)

        rvLista.addItemDecoration(
            DividerItemDecoration(
                this,
                RecyclerView.VERTICAL
            )
        )

        // Adicionar nome a lista
        btnAdicionar.setOnClickListener {
            val nomeAdicionado = adicionarNome.text.toString()
            if (nomeAdicionado.isNotEmpty()) {
                //lista.add(nomeAdicionado)
                participante.adicionarNome(nomeAdicionado)
                adicionarNome.text.clear()
            }
            else {
                Toast.makeText(this, "Insira um nome!", Toast.LENGTH_LONG).show()
            }

        }

        btnSortear.setOnClickListener {
            if(participante.listaParticipantes.isNotEmpty()) {
                val numeroAleatorio = Random.nextInt((participante.listaParticipantes.size).toInt())
                val nomeSorteado = participante.listaParticipantes[numeroAleatorio].nome

                val intent = Intent(this, NomeSorteadoActivity::class.java).apply {
                    putExtra("nome", nomeSorteado)
                }
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "A lista está vazia!", Toast.LENGTH_LONG).show()
            }
        }

    }
}