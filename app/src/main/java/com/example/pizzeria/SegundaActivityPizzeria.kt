package com.example.pizzeria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SegundaActivityPizzeria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_pizzeria)

        val lista = intent.getStringArrayListExtra("lista")
        val entrega = intent.getStringExtra("entrega")
        var stringLista:String=""
        if (lista != null) {
            for(l:String in lista){
                stringLista+=l+"\n"


            }
        }
        val tv: TextView = findViewById(R.id.resultados)
        tv.text = "Lista ingredientes:\n$stringLista" +
                "\nLa entrega es en :\n$entrega"

        val boton: Button=findViewById(R.id.boton)
        boton.setOnClickListener {
            Toast.makeText(this,"Pedido Confirmado", Toast.LENGTH_LONG).show()
        }

    }
}