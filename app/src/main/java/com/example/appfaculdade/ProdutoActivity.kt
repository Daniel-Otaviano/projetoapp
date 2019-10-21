package com.example.appfaculdade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.toolbar.*

class ProdutoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)

    
    
        val produto = intent.extras?.getString("nomeDoProduto", "") // caso não tenha nada ele dá um valor default vazio


        app_toolbar.title = produto


       setSupportActionBar(app_toolbar)
        
          supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}
