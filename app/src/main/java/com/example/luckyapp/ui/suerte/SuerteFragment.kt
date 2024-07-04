package com.example.luckyapp.ui.suerte

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.luckyapp.databinding.FragmentSuerteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuerteFragment : Fragment() {

    private val suerteViewModel by viewModels<SuerteViewModel>()
    private var _binding: FragmentSuerteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuerteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}