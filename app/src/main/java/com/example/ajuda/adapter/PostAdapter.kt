package com.example.ajuda.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ajuda.R
import com.example.ajuda.model.Postagem

class PostAdapter: RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var postList = emptyList<Postagem>()

    class PostViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        var nome = view.findViewById<TextView>(R.id.feedNome)
        var titulo = view.findViewById<TextView>(R.id.feedTitulo)
        var descricao = view.findViewById<TextView>(R.id.feedDescricao)
        var imagemPerfil = view.findViewById<ImageView>(R.id.feedImagem)
        var imagemPost = view.findViewById<ImageView>(R.id.feedImagem)
        var botãoPostar = view.findViewById<Button>(R.id.buttonPublicar)
        var tema = view.findViewById<TextView>(R.id.spinnerCategoria)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.postagem_card_layout, parent, false)

        return PostViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]

        holder.nome.text = post.autor
        holder.descricao.text = post.descricao
        holder.titulo.text = post.titulo
        holder.tema.text = post.tema.descricao
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    fun setList(list: List<Postagem>) {
        postList = list
        notifyDataSetChanged()
    }

}