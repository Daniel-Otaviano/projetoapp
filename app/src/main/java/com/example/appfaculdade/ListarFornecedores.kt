package com.example.appfaculdade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_listar_fornecedores.*
import kotlinx.android.synthetic.main.toolbar.*

class ListarFornecedores : AppCompatActivity() {

    private lateinit var fornecedorAdapter: FornecedorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_fornecedores)

        //adicionar o actionbar /Toolbar.
        setSupportActionBar(app_toolbar)
        // exibe a setinha de voltar na action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //adapter para listar fonecerdores
        fornecedorAdapter = FornecedorAdapter(this, mutableListOf())
        rv_lista_fornecedores?.apply {
            layoutManager = LinearLayoutManager(this@ListarFornecedores)
            adapter = fornecedorAdapter
        }

        val context = this
        Thread({
            //verificar ws
            val listaFonecedores = getListaDeFornecedores()
            runOnUiThread {
                fornecedorAdapter.listaDeFornecedores = listaFonecedores
                fornecedorAdapter.notifyDataSetChanged() // avisa que a lista mudou

            }
        }).start()

        //adicionar novo fornecedor
        bt_add_fornecedor.setOnClickListener {
            startActivity(Intent(this, CadastroFornecedorActivity::class.java))
        }

        bt_atualizarr.setOnClickListener {
            val context = this
            pb_atualizando_lista.visibility = View.VISIBLE
            Thread({
                //verificar ws
                val listaFonecedores = getListaDeFornecedores()
                runOnUiThread {
                    fornecedorAdapter.listaDeFornecedores = listaFonecedores
                    fornecedorAdapter.notifyDataSetChanged() // avisa que a lista mudou
                    pb_atualizando_lista.visibility = View.GONE
                }
            }).start()
        }
    }


    fun getListaDeFornecedores(): MutableList<Fornecedor> {
        val dao = DatabaseManger.getDatabase(this)?.fornecedorDAO()
        dao?.let {
            return it.findAll()
        }
        return ArrayList<Fornecedor>()

    }
}
