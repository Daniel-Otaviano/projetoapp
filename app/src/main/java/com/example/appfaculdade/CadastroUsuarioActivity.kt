package com.example.appfaculdade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.toolbar.*


class CadastroUsuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        setSupportActionBar(app_toolbar)
        // exibe a setinha de voltar na action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
