package com.example.pizzeria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import com.example.pizzeria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var entrega: String

        binding.radiogroup.setOnCheckedChangeListener  { _,claveloqueyoquiera ->
            //2 parametros:  1: _ =null en java 2: lo que yo quiera "claveloqueyoquiera" para referenciarlo despues en el when
            when (claveloqueyoquiera){
                R.id.domicilio -> Toast.makeText(this,"Entrega a Domicilio", Toast.LENGTH_SHORT).show()
                R.id.local -> Toast.makeText(this,"Recoger en local",Toast.LENGTH_SHORT).show()
            }
        }

        binding.jamonserrano.setOnClickListener { onCheckboxClicked(it) }




        binding.botonCalcular.setOnClickListener {
            val lista = ArrayList<String>()
            for (ingrediente in Ingredientes.values()) {
                when (ingrediente.toString()) {
                    binding.aceitunas.text -> {
                        if (binding.aceitunas.isChecked) lista.add(ingrediente.toString())
                    }

                    binding.jamonserrano.text -> {
                        if (binding.jamonserrano.isChecked) lista.add(ingrediente.toString())
                    }

                    binding.anchoas.text -> {
                        if (binding.anchoas.isChecked) lista.add(ingrediente.toString())
                    }

                    binding.bacon.text -> {
                        if (binding.bacon.isChecked) lista.add(ingrediente.toString())
                    }

                    binding.champinhones.text -> {
                        if (binding.champinhones.isChecked) lista.add(ingrediente.toString())
                    }

                    binding.peperoni.text -> {
                        if (binding.peperoni.isChecked) lista.add(ingrediente.toString())
                    }

                }
            }


            if (binding.local.isChecked) entrega = "Local"
            else entrega = "Domicilio"
            val intent = Intent(this, SegundaActivityPizzeria::class.java)
            intent.putStringArrayListExtra("lista", lista)
            intent.putExtra("entrega", entrega)
            startActivity(intent)


        }
    }

    private fun onCheckboxClicked(view: View) {
        val checked=(view as CheckBox).isChecked
        when (view.id){
            R.id.anchoas -> Toast.makeText(this,"Anchoas seleccionado", Toast.LENGTH_SHORT).show()
        }
    }
}