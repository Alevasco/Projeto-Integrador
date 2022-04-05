package com.example.ajuda

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ajuda.databinding.FragmentPostagemBinding
import com.example.ajuda.model.Postagem
import com.example.ajuda.model.Tema
import java.time.LocalDate

class PostagemFragment : Fragment() {

    private var temaSelecionado = 0L
    private var postagemSelecionada: Postagem? = null
    private lateinit var binding: FragmentPostagemBinding
    private  val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPostagemBinding.inflate(layoutInflater, container, false)

        carregarDados()

        mainViewModel.listPost()

        mainViewModel.myTemaResponse.observe(viewLifecycleOwner){
            response -> Log.d("ErroRequisicao", response.body().toString())
            spinnerTema(response.body())
        }

        binding.buttonPublicar.setOnClickListener {
           inserirNoBanco()
        }

        return binding.root
    }

    fun spinnerTema(tema: List<Tema>?){

        if(tema != null){
            binding.spinnerCategoria.adapter = ArrayAdapter(
                requireContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                tema
            )

          binding.spinnerCategoria.onItemSelectedListener =
          object :  AdapterView.OnItemSelectedListener{
              override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                  val temaSelecionadoFun = binding
                      .spinnerCategoria.selectedItem as Tema

                  temaSelecionado = temaSelecionadoFun.id

              }

              override fun onNothingSelected(p0: AdapterView<*>?) {
                  TODO("Not yet implemented")
              }
          }
        }
    }

    private fun verificarCampos(
        titulo: String, desc: String, imagem: String

    ): Boolean {

        return !(
                (titulo == "" || titulo.length < 5 || titulo.length > 30) ||
                (desc == "" || desc.length < 5 || desc.length > 200) ||
                imagem == ""
                )

    }

    fun inserirNoBanco(){

        val titulo = binding.textTitulo.text.toString()
        val desc = binding.textDescricao.text.toString()
        val imagem = binding.textLinkImagem.text.toString()
        val dataHora = LocalDate.now().toString()
        val autor = binding.textNome.text.toString()
        val tema = Tema(temaSelecionado, null, null)

        if(verificarCampos(titulo,desc,imagem)){
            if(postagemSelecionada == null) {
                val postagem = Postagem(
                    0, titulo, desc, imagem, dataHora, autor, tema
                )
                mainViewModel.addPost(postagem)
            }else{
                val postagem = Postagem(
                    postagemSelecionada?.id!!,
                    titulo, desc, imagem, dataHora, autor, tema
                )
                mainViewModel.updatePostagem(postagem)
            }
            Toast.makeText(
             context,"Postagem salva!",
            Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.action_postagemFragment_to_listaPostagemFragment)
        }else{
            Toast.makeText(
                context,"Preencha os campos corretamente!",
                Toast.LENGTH_LONG
            ).show()
        }

    }

    private fun carregarDados(){
        postagemSelecionada = mainViewModel.postagemSelecionada
        if (postagemSelecionada != null){
            binding.textTitulo.setText(postagemSelecionada?.titulo)
            binding.textDescricao.setText(postagemSelecionada?.descricao)
            binding.textLinkImagem.setText(postagemSelecionada?.imagem)
            binding.textNome.setText(postagemSelecionada?.autor)
            binding.textData.setText(postagemSelecionada?.dataHora)
            binding.spinnerCategoria.setSelection(postagemSelecionada!!.tema.id!!.toInt())
        }else{
            binding.textTitulo.text = null
            binding.textDescricao.text = null
            binding.textNome.text = null
            binding.textLinkImagem.text = null
            binding.textData.text = null
        }
    }

  }