package com.example.pizzeria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.app.AlertDialog
import android.content.DialogInterface

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
            showAlertDialog()
        }

    }
    private fun showToast(string: String) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show()

    }
    private fun showAlertDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)

        alertDialogBuilder.setTitle("Confirmacion de Pedido")
        alertDialogBuilder.setMessage("El pedido va a pasar a ser procesado")
        alertDialogBuilder.setPositiveButton("Aceptar") { dialog: DialogInterface, which: Int ->
           showToast("Pedido Confirmado")
        }
        alertDialogBuilder.setNegativeButton("Cancelar") { dialog: DialogInterface, which: Int ->
           showToast("Pedido cancelado")
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}