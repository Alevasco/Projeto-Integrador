
package com.example.ajuda.model

data class Postagem(
    var id: Long,
    var titulo: String,
    var descricao: String,
    var imagem: String,
    var dataHora: String,
    var autor: String,
    var tema: Tema
) {


}