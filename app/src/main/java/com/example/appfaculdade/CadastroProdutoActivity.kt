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

        //adicionar o actionbar /Toolbar. app_toolbar é o componente la da do toolbar.xml(ele pode ser adicionado em qualquer layout, usando o include(veja activity_produto.xml)
        setSupportActionBar(app_toolbar)

        // exibe a setinha de voltar na action bar. Para fazer ela funcionar, voce pode adicionar um parentActivity em CadastroProdutoActivity la no AndroidManifest.xml
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        // salvar novo produto
        bt_salvar_produto.setOnClickListener {

            val nome = et_produto_nome.text.toString()
            val quantidade = et_produto_quantidade.text.toString()

            SimuladorWS.cadastrar(Produto(nome, quantidade.toInt()))

            startActivity(Intent(this@CadastroProdutoActivity, MainActivity::class.java))

        }

    }
}
