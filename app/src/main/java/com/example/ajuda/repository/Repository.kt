package com.example.ajuda.repository

import com.example.ajuda.api.RetrofitInstance
import com.example.ajuda.model.Postagem
import com.example.ajuda.model.Tema
import retrofit2.Response

class Repository {
    suspend fun listTema(): Response<List<Tema>>{
        return RetrofitInstance.api.listTema()
    }

    suspend fun  addPost(postagem: Postagem): Response<Postagem>{
        return RetrofitInstance.api.addPost(postagem)
    }

    suspend fun listPost(): Response<List<Postagem>>{
        return RetrofitInstance.api.listPost()
    }
}