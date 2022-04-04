package com.example.ajuda

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ajuda.model.Postagem
import com.example.ajuda.model.Tema
import com.example.ajuda.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: Repository
        ): ViewModel() {

    var postagemSelecionada: Postagem? = null

    private var _myTemaResponse =
        MutableLiveData<Response<List<Tema>>>()

    val  myTemaResponse: LiveData<Response<List<Tema>>> =
        _myTemaResponse

    private val _myPostagemResponse =
        MutableLiveData<Response<List<Postagem>>>()

    val myPostagemResponse: LiveData<Response<List<Postagem>>> =
        _myPostagemResponse

    init {
        listTema()
    }

    fun listTema(){
        viewModelScope.launch {
            try {
                val response = repository.listTema()
                _myTemaResponse.value = response
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun addPost(postagem: Postagem){
        viewModelScope.launch {
            try {
                repository.addPost(postagem)
                listPost()
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun listPost(){
        viewModelScope.launch {
            try{
                val response = repository.listPost()
                _myPostagemResponse.value = response
            }catch (e: Exception){
                Log.e("Developer","Error", e)
            }
        }
    }

    fun updatePostagem(postagem: Postagem){
        viewModelScope.launch {
            try{
                repository.updatePostagem(postagem)
                listPost()
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }

}