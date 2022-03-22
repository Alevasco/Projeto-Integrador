package com.example.ajuda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ajuda.adapter.PostAdapter
import com.example.ajuda.model.Postagem

class ListaPostagemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_lista_postagem, container, false)

        val listaPostagens = listOf<Postagem>(
            Postagem(
                "edu",
                "quebrei os dedos",
                "no jiu quebraram meus dedos",
                "Imagem Perfil",
                "LInk imagem"
            ),Postagem(
                "edu2",
                "quebrei os dedos",
                "no jiu quebraram meus dedos",
                "Imagem Perfil",
                "LInk imagem"
            ),Postagem(
                "edu3",
                "quebrei os dedos",
                "no jiu quebraram meus dedos",
                "Imagem Perfil",
                "LInk imagem"
            )
        )
        val recyclerListPost = view.findViewById<RecyclerView>(R.id.recycler)

        val adpterListPost = PostAdapter()

        recyclerListPost.layoutManager = LinearLayoutManager(context)

        recyclerListPost.adapter = adpterListPost

        recyclerListPost.setHasFixedSize(true)

        adpterListPost.setList(listaPostagens)

        return view
    }
}