package com.example.appfaculdade


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(app_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // exibe a setinha de voltar na action bar
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu) // muda o icone do Actionbar


        drawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {}

            override fun onDrawerOpened(drawerView: View) {
                supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_action_sair)
            }

            override fun onDrawerClosed(drawerView: View) {
                supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu)
            }

            override fun onDrawerStateChanged(newState: Int) {
            }
        })


        navmenu.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_adicionar_usuario -> startActivity(Intent(this, CadastroUsuarioActivity::class.java)) // Abre  a tela de cadasdtro de Usuário
                R.id.action_adicionar_produto -> startActivity(Intent(this, CadastroProdutoActivity::class.java)) // Abre  a tela de cadasdtro de Produto
                R.id.action_adicionar_fornecedor -> startActivity(Intent(this, CadastroFornecedorActivity::class.java)) // Abre  a tela de cadasdtro de Fornecedor
                R.id.action_config -> {
                    // Abrir a tela de Configurações
                    startActivity(Intent(this, ConfiguracoesActivity::class.java))
                }
                R.id.action_sair -> {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish() // destroi essa activity e volta pra anteiror
        }
            }

            true // retorna true para o click no item
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)


        val campoPesquisa = menu?.findItem(R.id.action_buscar)
        val persquisa = campoPesquisa?.actionView as SearchView
        persquisa.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@MainActivity, "Valor Pesquisado " + query, Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                if (!s.equals(""))
                    Toast.makeText(this@MainActivity, "Pesquisando por...  " + s, Toast.LENGTH_SHORT).show()
                return false
            }

        })// Fim da ação de pesquisar

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            android.R.id.home -> drawerLayout.openDrawer(Gravity.LEFT)

            R.id.action_atualizar -> {
                pb_atualizando_pesquisa.visibility = View.VISIBLE // fica visivel

                Handler().postDelayed(Runnable {
                    pb_atualizando_pesquisa.visibility = View.INVISIBLE // ou pode usar View.GONE
                }, 10000) // 10 segundos em millisegundos
            }
        }

        return true
    }

}
