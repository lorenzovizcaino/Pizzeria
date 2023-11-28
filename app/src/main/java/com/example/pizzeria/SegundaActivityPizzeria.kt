package com.example.pizzeria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.view.Menu
import android.view.MenuItem
import android.webkit.URLUtil

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

    //menu desde aqui
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menupizzeria, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId==R.id.acerca_de){
            showToast(getString(R.string.autor))
        }
        if(item.itemId==R.id.pizza_hut){
            openWebPage(this,"https://www.pizzahut.es/")
        }
        if(item.itemId==R.id.inicio){
            val intent= Intent(this,InicioActivity::class.java)
            startActivity(intent)
        }
        if(item.itemId==R.id.compartir){
            showToast(getString(R.string.compartir))

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, getString(R.string.texto_enviar))
                type = "text/plain"
            }

            try {

                startActivity(sendIntent)
            } catch (e: ActivityNotFoundException) {
                showToast(getString(R.string.no_se_puede))

            }

        }
        return true
    }

    fun openWebPage(context: Context, url: String?) {
        try {
            if (!URLUtil.isValidUrl(url)) {
                showToast(getString(R.string.enlace_no_valido))

            } else {
                val intent = Intent (Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(intent)

            }
        } catch (e: ActivityNotFoundException) {
            showToast(getString(R.string.no_hay_navegador))
        }
    }
    //menu hasta aqui

}