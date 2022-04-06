package com.example.ajuda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ajuda.databinding.FragmentCadastroBinding

class cadastroFragment : Fragment() {

    private lateinit var binding: FragmentCadastroBinding
    private val mainViewModle: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCadastroBinding.inflate(layoutInflater, container, false)

        binding.btCadastrar.setOnClickListener {
            findNavController().navigate(R.id.action_cadastroFragment_to_menuFragment)
        }

        return binding.root
    }

}