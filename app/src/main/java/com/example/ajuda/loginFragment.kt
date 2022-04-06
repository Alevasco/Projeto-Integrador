package com.example.ajuda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ajuda.databinding.FragmentLoginBinding
import com.example.ajuda.databinding.FragmentPostagemBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private  val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        binding.btEntrar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_menuFragment)
        }

        binding.textTelaCadastro.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_cadastroFragment)
        }

        return binding.root
    }
}