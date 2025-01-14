package com.example.appsorteio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ParticipanteAdapter () : Adapter<ParticipanteAdapter.ParticipanteViewHolder>() {
    val listaParticipantes = mutableListOf<ListaParticipante>()

    fun adicionarNome(nome: String) {
        listaParticipantes.add(ListaParticipante(nome))
        notifyItemInserted(listaParticipantes.size - 1)
    }

    inner class ParticipanteViewHolder(
        itemView: View
    ) : ViewHolder( itemView ) {
        val textNome: TextView = itemView.findViewById(R.id.text_nome)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticipanteViewHolder {

        val layoutInflater = LayoutInflater.from(
            parent.context
        )

        val itemView = layoutInflater.inflate(
            R.layout.view, parent, false
        )

        return ParticipanteViewHolder( itemView )
    }

    override fun onBindViewHolder(holder: ParticipanteViewHolder, position: Int) {

        val participante = listaParticipantes[position]
        holder.textNome.text = participante.nome
    }

    override fun getItemCount(): Int {

        return listaParticipantes.size
    }
}