package com.example.ajuda.model

data class Tema (
    val id: Long,
    var descricao: String?,
    var postagens : List<Postagem>?
    ){

    override fun toString(): String {
        return descricao!!
    }

}




