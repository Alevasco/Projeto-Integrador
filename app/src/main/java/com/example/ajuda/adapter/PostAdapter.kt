package com.example.ajuda.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ajuda.MainViewModel
import com.example.ajuda.R
import com.example.ajuda.model.Postagem

class PostAdapter(
    private var taskItemClickListener: TaskItemClickListener,
    private var mainViewModel: MainViewModel,
    private var context: Context

): RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

    private var postList = emptyList<Postagem>()

    class PostViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        var nome = view.findViewById<TextView>(R.id.feedNome)
        var titulo = view.findViewById<TextView>(R.id.feedTitulo)
        var descricao = view.findViewById<TextView>(R.id.feedDescricao)
        var imagemPost = view.findViewById<ImageView>(R.id.imageView)
        var botãoPostar = view.findViewById<Button>(R.id.buttonPublicar)
        var tema = view.findViewById<TextView>(R.id.textTema)
        var buttonEditar = view.findViewById<ImageButton>(R.id.buttonEdit)
        var buttonDeletar = view.findViewById<Button>(R.id.buttonDeletar)

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

        Glide.with(context)
            .load(post.imagem)
            .placeholder(android.R.drawable.ic_menu_report_image)
            .into(holder.imagemPost)

        holder.buttonEditar.setOnClickListener {
            taskItemClickListener.onTaskClicked(post)
        }

        holder.buttonDeletar.setOnClickListener {
            createDialog(post)
            //
        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }

    fun setList(list: List<Postagem>) {
        postList = list
        notifyDataSetChanged()
    }

    fun createDialog(post: Postagem) {
        val alert = androidx.appcompat.app.AlertDialog.Builder(context)
        alert.setTitle("DELETAR")
        alert.setMessage("Deseja mesmo deletar o Post")
        alert.setPositiveButton("Sim", {dialog, id ->
            dialog.cancel()
            mainViewModel.deletarPostagem(post.id)
        })
        alert.setNegativeButton("Não", {dialog, id ->
            dialog.cancel()
        })
        alert.show()
    }

}