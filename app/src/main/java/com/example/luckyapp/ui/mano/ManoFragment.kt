package com.example.luckyapp.ui.mano

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.luckyapp.databinding.FragmentManoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ManoFragment : Fragment() {

    private val manoViewModel by viewModels<ManoViewModel>()
    private var _binding: FragmentManoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentManoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}