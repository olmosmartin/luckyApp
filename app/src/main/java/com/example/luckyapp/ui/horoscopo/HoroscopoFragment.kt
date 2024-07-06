package com.example.luckyapp.ui.horoscopo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.luckyapp.databinding.FragmentHoroscopoBinding
import com.example.luckyapp.domain.model.HoroscopoInfo
import com.example.luckyapp.ui.horoscopo.adapter.HoroscopoAdaptervar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoFragment : Fragment() {

    private val horoscopoViewModel by viewModels<HoroscopoViewModel>()
    private var _binding: FragmentHoroscopoBinding? = null
    private val binding get() = _binding!!
    private lateinit var horoscopoAdapter: HoroscopoAdaptervar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initUI()
    }

    private fun initUI() {
        initRecyclerView()
        initUIState()
    }

    private fun initUIState() {
        //creo una corrutina lifecycleScope que sirve en los fragments y activity para lanzar corrutinas
        //que se ejecuten en el ciclo de vida del fragment, muriendo cuando muera el fragment
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopoViewModel.horoscopo.collect { listHoroscopoInfo ->
                    //cada vez q modifique _horoscopo.value en HoroscopoViewModel se va ejecutar este codigo:
                    horoscopoAdapter.updateList(listHoroscopoInfo)
                }
            }
        }
    }

    private fun initRecyclerView() {
        //por defecto en HoroscopoAdaptervar queda lista vacia si no envía nada al constructor
        horoscopoAdapter = HoroscopoAdaptervar()

        //le paso dos columnas en lugar de usar LinearLayoutManager
        binding.rvHoroscopoList.layoutManager = GridLayoutManager(context, 2)
        binding.rvHoroscopoList.adapter = horoscopoAdapter

        /*
            otra forma:
            binding.rvHoroscopoList.apply {
                adapter = horoscopoAdapter
                layoutManager = LinearLayoutManager(context)
            }
        */
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Cancela la corrutina para evitar observadores duplicados
        lifecycleScope.coroutineContext.cancelChildren()
    }

}