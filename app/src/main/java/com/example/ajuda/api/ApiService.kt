package com.example.ajuda.api

import com.example.ajuda.model.Postagem
import com.example.ajuda.model.Tema
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

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

}