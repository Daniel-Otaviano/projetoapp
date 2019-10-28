package com.example.appfaculdade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_produto.*
import kotlinx.android.synthetic.main.toolbar.*

class CadastroProdutoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)

        setSupportActionBar(app_toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // salvar novo produto
        bt_salvar_produto.setOnClickListener {

            val nome = et_produto_nome.text.toString()
            val cor = et_produto_cor.text.toString()
            val tamanho = et_produto_tamanho.text.toString()
            // criar um metodo post no service

            Thread({
                //verificar ws
                ProdutoWS.save(Produto(cor, 0, nome, tamanho.toInt()))
                runOnUiThread {
                    startActivity(Intent(this@CadastroProdutoActivity, MainActivity::class.java))
                }
            }).start()

        }
    }
}