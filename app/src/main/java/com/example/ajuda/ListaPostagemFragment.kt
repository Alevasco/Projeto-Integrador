package com.example.ajuda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ajuda.adapter.PostAdapter
import com.example.ajuda.adapter.TaskItemClickListener
import com.example.ajuda.databinding.FragmentListaPostagemBinding
import com.example.ajuda.databinding.FragmentPostagemBinding
import com.example.ajuda.model.Postagem
import com.example.ajuda.model.Tema
import com.google.android.material.floatingactionbutton.FloatingActionButton

class   ListaPostagemFragment : Fragment(), TaskItemClickListener{

    private lateinit var binding: FragmentListaPostagemBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListaPostagemBinding.inflate(layoutInflater, container, false)

        mainViewModel.listPost()

        val adpterListPost = PostAdapter(this, mainViewModel, context!!)

        binding.recycler.layoutManager = LinearLayoutManager(context)

        binding.recycler.adapter = adpterListPost

        binding.recycler.setHasFixedSize(true)


        binding.buttonAdicionar.setOnClickListener {
            mainViewModel.postagemSelecionada = null
            findNavController().navigate(R.id.action_listaPostagemFragment_to_postagemFragment)
        }

        mainViewModel.myPostagemResponse.observe(viewLifecycleOwner){
            response -> if(response.body() != null){
                adpterListPost.setList(response.body()!!)
            }
        }

        return binding.root
    }

    override fun onTaskClicked(postagens: Postagem) {
        mainViewModel.postagemSelecionada = postagens
        findNavController().navigate(R.id.action_listaPostagemFragment_to_postagemFragment)
    }
}