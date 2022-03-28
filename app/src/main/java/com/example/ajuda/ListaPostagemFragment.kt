package com.example.ajuda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ajuda.adapter.PostAdapter
import com.example.ajuda.databinding.FragmentListaPostagemBinding
import com.example.ajuda.databinding.FragmentPostagemBinding
import com.example.ajuda.model.Postagem
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaPostagemFragment : Fragment() {

    private lateinit var binding: FragmentListaPostagemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListaPostagemBinding.inflate(layoutInflater, container, false)

        val listaPostagens = listOf<Postagem>(
            Postagem(
                "Edu",
                "Quebrei os dedos",
                "No jiu quebraram meus dedos",
                "Imagem Perfil",
                "LInk imagem"
            ),Postagem(
                "Edu2",
                "Quebrei os dedos",
                "No jiu quebraram meus dedos",
                "Imagem Perfil",
                "LInk imagem"
            ),Postagem(
                "Edu3",
                "Quebrei os dedos",
                "No jiu quebraram meus dedos",
                "Imagem Perfil",
                "LInk imagem"
            )
        )

        val adpterListPost = PostAdapter()

        binding.recycler.layoutManager = LinearLayoutManager(context)

        binding.recycler.adapter = adpterListPost

        binding.recycler.setHasFixedSize(true)

        adpterListPost.setList(listaPostagens)

        binding.buttonAdicionar.setOnClickListener {
            findNavController().navigate(R.id.action_listaPostagemFragment_to_postagemFragment)
        }

        return binding.root
    }
}