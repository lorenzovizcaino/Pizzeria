package com.example.pizzeria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pizzeria.databinding.ActivityInicioBinding
//co
class InicioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonInicio.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}