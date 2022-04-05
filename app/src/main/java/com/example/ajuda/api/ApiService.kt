package com.example.ajuda.api

import com.example.ajuda.model.Postagem
import com.example.ajuda.model.Tema
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("temas")
    suspend fun listTema(): Response<List<Tema>>

    @POST("postagens")
    suspend fun addPost(
        @Body postagem: Postagem
    ): Response<Postagem>

    @GET("postagens")
    suspend fun listPost(): Response<List<Postagem>>

    @PUT("postagens")
    suspend fun updatePostagem(
        @Body postagens: Postagem
    ): Response<Postagem>

    @DELETE("postagens/{id}")
    suspend fun deletarPostagem(
        @Path("id") valor: Long
    ): Response<Postagem>

}