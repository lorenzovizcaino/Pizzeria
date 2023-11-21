package com.example.pizzeria

import android.content.Intent
import android.content.pm.ActivityInfo
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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var entrega: String

        //eventos de botones de radio
        binding.radiogroup.setOnCheckedChangeListener  { _,claveloqueyoquiera ->
            //2 parametros:  1: _ =null en java 2: lo que yo quiera "claveloqueyoquiera" para referenciarlo despues en el when
            when (claveloqueyoquiera){
                R.id.domicilio -> showToast(getString(R.string.entrega_domicilio))
                R.id.local -> showToast(getString(R.string.local))

            }
        }

        //eventos de checkbox
        binding.aceitunas.setOnClickListener{
            DiferenciarCheckbox(binding.aceitunas)
        }
        binding.jamonserrano.setOnClickListener{
            DiferenciarCheckbox(binding.jamonserrano)
        }
        binding.anchoas.setOnClickListener{
            DiferenciarCheckbox(binding.anchoas)
        }
        binding.bacon.setOnClickListener{
            DiferenciarCheckbox(binding.bacon)
        }
        binding.champinhones.setOnClickListener{
            DiferenciarCheckbox(binding.champinhones)
        }
        binding.peperoni.setOnClickListener{
            DiferenciarCheckbox(binding.peperoni)
        }








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


            if (binding.local.isChecked) entrega = getString(R.string.local)
            else entrega = getString(R.string.domicilio)
            val intent = Intent(this, SegundaActivityPizzeria::class.java)
            intent.putStringArrayListExtra("lista", lista)
            intent.putExtra("entrega", entrega)
            startActivity(intent)


        }
    }

    private fun DiferenciarCheckbox(checkBox: CheckBox){
        val estaChequeado=checkBox.isChecked
        val checkBoxText=checkBox.text
        if(estaChequeado){
            showToast("$checkBoxText "+getString(R.string.selecionado))
        }else{
            showToast("$checkBoxText "+getString(R.string.deselecionado))
        }
    }

    private fun showToast(string: String) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show()

    }


}