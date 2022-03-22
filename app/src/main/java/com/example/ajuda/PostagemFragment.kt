package com.example.ajuda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class PostagemFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_postagem, container, false)

        val butaoPubli = view.findViewById<Button>(R.id.buttonPublicar)

        butaoPubli.setOnClickListener {
            findNavController().navigate(R.id.action_postagemFragment_to_listaPostagemFragment)
        }

        return view
    }

}