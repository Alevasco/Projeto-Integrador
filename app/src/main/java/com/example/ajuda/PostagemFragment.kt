package com.example.ajuda

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ajuda.databinding.FragmentPostagemBinding

class PostagemFragment : Fragment() {

    private lateinit var binding: FragmentPostagemBinding
    private  val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPostagemBinding.inflate(layoutInflater, container, false)

        mainViewModel.myTemaResponse.observe(viewLifecycleOwner){
            response -> Log.d("ErroRequisicao", response.body().toString())
        }

        binding.buttonPublicar.setOnClickListener {
            if(verificarCampos()) {

                Toast.makeText(
                    context,"Postagem salva com sucesso",
                    Toast.LENGTH_LONG).show()

                findNavController().navigate(R.id.action_postagemFragment_to_listaPostagemFragment)

            }else {
                Toast.makeText(
                    context,"Preencha todos os campos",
                    Toast.LENGTH_LONG).show()
            }

        }

        return binding.root
    }

    private fun verificarCampos(): Boolean {
        if (binding.textTitulo.text.isEmpty() ||
            binding.textDescricao.text.isEmpty() ||
            binding.textLinkImagem.text.isEmpty()
        ) {
            return false

        }else {
            return true
        }
    }

}