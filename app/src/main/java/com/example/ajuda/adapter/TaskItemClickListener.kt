package com.example.ajuda.adapter

import com.example.ajuda.model.Postagem
import com.example.ajuda.model.Tema

interface TaskItemClickListener {

    fun onTaskClicked(postagens: Postagem)

}