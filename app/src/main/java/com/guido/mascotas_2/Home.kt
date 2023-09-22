package com.guido.mascotas_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.guido.mascotas_2.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigation()

    }

    private fun initNavigation() {
        val navHost = supportFragmentManager.findFragmentById(R.id.contenedor_nav_fragment) as NavHostFragment
            navController = navHost.navController
            binding.botonnavegationview.setupWithNavController(navController)
    }


}