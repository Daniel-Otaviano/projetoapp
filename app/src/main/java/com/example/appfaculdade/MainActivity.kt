package com.example.appfaculdade


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //adicionar o actionbar /Toolbar
        setSupportActionBar(app_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // exibe a setinha de voltar na action bar

        // Nova tela quando clicar nos botões
        val intent = Intent(this, ProdutoActivity::class.java)

        bt_action_produto_motog7.setOnClickListener {
            intent.putExtra("nomeDoProduto", "Moto G7")
            // chamamos a nova Tela
            startActivity(intent)
        }

        bt_action_produto_notebook.setOnClickListener {
            intent.putExtra("nomeDoProduto", "Notebook Dell")
            startActivity(intent)
        }

        bt_action_produto_monitor_lg.setOnClickListener {
            intent.putExtra("nomeDoProduto", "Monitor LG")
            startActivity(intent)
        }

    }

    // Adiciona o  main_menu(res/menu) no Toolbar/Actionbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val campoPesquisa = menu?.findItem(R.id.action_buscar)
        val persquisa = campoPesquisa?.actionView as SearchView
        persquisa.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            // Quando eu termino de pesquisar no campo
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@MainActivity, "Valor Pesquisado " + query, Toast.LENGTH_SHORT).show()
                return false
            }

            //quando o texto muda
            override fun onQueryTextChange(s: String): Boolean {
                if (!s.equals(""))
                    Toast.makeText(this@MainActivity, "Pesquisando por...  " + s, Toast.LENGTH_SHORT).show()
                return false
            }

        })

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         when (item.itemId) {
             R.id.action_adicionar -> {
                // vamos abrir a tela de cadastro
                startActivity(Intent(this, CadastroActivity::class.java))
            }
            R.id.action_atualizar -> {
                 pb_atualizando_pesquisa.visibility = View.VISIBLE // fica visivel

                 Handler().postDelayed(Runnable {
                    pb_atualizando_pesquisa.visibility = View.INVISIBLE // ou pode usar View.GONE
                }, 10000) // 10 segundos em millisegundos
            }
            R.id.action_config -> {
                // Abrir a tela de Configurações
                startActivity(Intent(this, ConfiguracoesActivity::class.java))
            }

            R.id.action_sair -> {
                startActivity(Intent(this, LoginActivity::class.java))
                finish() // destroi essa activity e volta pra anteiror
                       }
        }
        // teste
        return true
    }

}
