package com.example.appsorteio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.appsorteio.databinding.CardViewBinding

class ParticipanteAdapter : Adapter<ParticipanteAdapter.ParticipanteViewHolder>() {
    val listaParticipantes = mutableListOf<ListaParticipante>()

    fun adicionarNome(nome: String) {
        listaParticipantes.add(ListaParticipante(nome))
        notifyItemInserted(listaParticipantes.size - 1)
    }

    private fun removerNome(nomeParticipante: String) {
        val posicao = listaParticipantes.indexOfFirst { it.nome == nomeParticipante }

        if (posicao != -1) {
            listaParticipantes.removeAt(posicao) // Remove o item da lista
            notifyItemRemoved(posicao) // Notifica o RecyclerView sobre a remoção
        }

    }

    inner class ParticipanteViewHolder(
        val binding: CardViewBinding
    ) : ViewHolder( binding.root )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticipanteViewHolder {

        val layoutInflater = LayoutInflater.from(
            parent.context
        )

        val itemView = CardViewBinding.inflate(
            layoutInflater, parent, false
        )

        return ParticipanteViewHolder( itemView )
    }

    override fun onBindViewHolder(holder: ParticipanteViewHolder, position: Int) {

        val participante = listaParticipantes[position]
        holder.binding.textCardNome.text = participante.nome

        holder.binding.ivCardRemover.setOnClickListener {
            AlertDialog.Builder(holder.binding.ivCardRemover.context)
                .setTitle("Confirmar exclusão do item!")
                .setMessage("Tem certeza que deseja remover?")
                .setNegativeButton("Não") { _, _ ->
                }
                .setPositiveButton("Sim"){_, _ ->
                    removerNome(holder.binding.textCardNome.text.toString())
                }
                .setCancelable(false)
                .create()
                .show()
        }
    }

    override fun getItemCount(): Int {

        return listaParticipantes.size
    }
}