package com.example.appsorteio

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appsorteio.databinding.ActivityNameBinding
import kotlin.random.Random

class NameActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNameBinding.inflate(layoutInflater)
    }

    private lateinit var participante: ParticipanteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        inicializarToolbar()

        //Inicialização do Adapter e configuração do RecyclerView
        participante = ParticipanteAdapter()
        binding.rvLista.adapter = participante
        binding.rvLista.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        //Adicionar nome a lista
        binding.btnAdicionar.setOnClickListener {
            val nomeAdicionado = binding.editAdicionarNome.text.toString()
            if (nomeAdicionado.isNotEmpty()) {
                participante.adicionarNome(nomeAdicionado)
                binding.editAdicionarNome.text?.clear()
            }
            else {
                Toast.makeText(this, "Insira um nome!", Toast.LENGTH_LONG).show()
            }

        }

        //Sortear nome da lista
        binding.btnSortear.setOnClickListener {
            if(participante.listaParticipantes.isNotEmpty()) {
                alertaRealizarSorteio()
            }
            else {
                Toast.makeText(this, "A lista está vazia!", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun inicializarToolbar() {
        setSupportActionBar(binding.includeToolbarNome.materialToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun alertaRealizarSorteio() {
        AlertDialog.Builder(this)
            .setTitle("Sorteio da lista!")
            .setMessage("Tem certeza que deseja sortear?")
            .setNegativeButton("Não") { _, _ -> }
            .setPositiveButton("Sim"){_, _ ->
                realizarSorteio()
            }
            .setCancelable(false)
            .create()
            .show()

    }

    private fun realizarSorteio() {
        val numeroAleatorio = Random.nextInt((participante.listaParticipantes.size))
        val nomeSorteado = participante.listaParticipantes[numeroAleatorio].nome

        val intent = Intent(this, NomeSorteadoActivity::class.java).apply {
            putExtra("nome", nomeSorteado)
        }
        startActivity(intent)
    }
}