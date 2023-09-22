


package com.guido.mascotas_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsetsController
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.guido.mascotas_2.data_base.db_mascotas
import com.guido.mascotas_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
                binding.fondo.animate().setStartDelay(1000).setDuration(6000).rotation(360f).withEndAction{
                    startActivity(Intent(this,Home::class.java))
                }   .start()

        pantallaCompleta()


    }

    private fun pantallaCompleta() {
        WindowInsetsControllerCompat(
            window,
            window.decorView
        ).hide(WindowInsetsCompat.Type.systemBars())
    }

}