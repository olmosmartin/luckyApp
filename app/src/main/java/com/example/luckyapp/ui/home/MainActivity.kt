package com.example.luckyapp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.luckyapp.R
import com.example.luckyapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding //nombre de la clase con activity al inicio y binding al final
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        initNavigation()
    }

    private fun initNavigation() {
        //inicio la navegacion con el id del FragmentContainerView y lo casteo a NavHostFragment
        val navHost =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHost.navController
        binding.bottonNavigation.setupWithNavController(navController)
    }

}