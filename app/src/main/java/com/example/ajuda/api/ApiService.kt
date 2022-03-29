package com.example.ajuda.api

import com.example.ajuda.model.Postagem
import com.example.ajuda.model.Tema
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("Tema")
    suspend fun listTema(): Response<List<Tema>>

    @POST("Postagem")
    suspend fun addPost(
        @Body postagem: Postagem
    ): Response<Postagem>

    @GET("Postagem")
    suspend fun listPost(): Response<List<Postagem>>
}