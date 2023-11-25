package com.example.pizzeria

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.URLUtil
import android.widget.Toast
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


    private fun showToast(string: String) {
        Toast.makeText(this,string, Toast.LENGTH_SHORT).show()

    }
}