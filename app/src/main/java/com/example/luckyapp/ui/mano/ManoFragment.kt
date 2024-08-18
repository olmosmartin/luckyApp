package com.example.luckyapp.ui.mano

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.PermissionChecker
import androidx.fragment.app.viewModels
import com.example.luckyapp.databinding.FragmentManoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ManoFragment : Fragment() {

    //usar CAMERA_PERMISSION sería lo mismo que poner el nombre de la constante: android.Manifest.permission.CAMERA
    //pero la declaro acá arriba porque la uso en varios lugares de este archivo y así queda más organizado
    companion object {
        private const val CAMERA_PERMISSION = android.Manifest.permission.CAMERA
    }

    private val manoViewModel by viewModels<ManoViewModel>()
    private var _binding: FragmentManoBinding? = null
    private val binding get() = _binding!!

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            //tiene permisos aceptados
            //lanzar la camara
        } else {
            Toast.makeText(
                requireContext(),
                "Acepta por permisos para poder usar esta funcionalidad",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentManoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //consulta si ya tiene los permisos cuando la vista se creo
        if (!checkCameraPermission()) {
            //si no tiene permisos los pide
            requestPermissionLauncher.launch(CAMERA_PERMISSION)
        } else {
            //si ya tiene los permisos, lanza la camara
        }
    }

    private fun checkCameraPermission(): Boolean {
        return PermissionChecker.checkSelfPermission(
            requireContext(),
            CAMERA_PERMISSION
        ) == PermissionChecker.PERMISSION_GRANTED
    }

}