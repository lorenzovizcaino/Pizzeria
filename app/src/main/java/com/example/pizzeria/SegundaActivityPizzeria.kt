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
        tv.text = getString(R.string.lista_ingredientes)+"\n$stringLista\n" +
                getString(R.string.entrega)+"\n$entrega"

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

        alertDialogBuilder.setTitle(getString(R.string.confirmacion_de_pedido))
        alertDialogBuilder.setMessage(getString(R.string.el_pedido_va_a_ser_procesado))
        alertDialogBuilder.setPositiveButton(getString(R.string.aceptar)) { dialog: DialogInterface, which: Int ->
            val string = getString(R.string.pedido_confirmado)

            showToast(string)
        }
        alertDialogBuilder.setNegativeButton(getString(R.string.cancelar)) { dialog: DialogInterface, which: Int ->
           showToast(getString(R.string.pedido_cancelado))
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}