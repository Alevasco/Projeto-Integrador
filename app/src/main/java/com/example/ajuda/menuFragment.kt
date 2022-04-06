package com.example.ajuda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ajuda.databinding.FragmentMenuBinding

class menuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBinding.inflate(layoutInflater, container, false)

        binding.btFeed.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_listaPostagemFragment)
        }

        return binding.root
    }
}