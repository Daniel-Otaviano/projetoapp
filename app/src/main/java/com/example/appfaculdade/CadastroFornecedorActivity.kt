package com.example.appfaculdade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.toolbar.*

class CadastroFornecedorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_fornecedor)

        //adicionar o actionbar /Toolbar.
        setSupportActionBar(app_toolbar)
        // exibe a setinha de voltar na action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}
