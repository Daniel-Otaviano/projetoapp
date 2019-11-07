package com.example.appfaculdade


import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.app.NotificationCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_header.view.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlin.concurrent.thread


class MainActivity : DebugActivity() {

    private var produtoAdapater: ProdutoAdapater? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(app_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // exibe a setinha de voltar na action bar
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu) // muda o icone do Actionbar


        // Verifica quando o Drawer está aberto ou fechado, mudando os Icones do mesmo
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
                R.id.action_adicionar_usuario -> startActivity(Intent(this, CadastroUsuarioActivity::class.java))
                R.id.action_adicionar_produto -> startActivity(Intent(this, CadastroProdutoActivity::class.java))
                R.id.action_adicionar_fornecedor -> startActivity(Intent(this, CadastroFornecedorActivity::class.java))
                R.id.action_listar_fornecedor -> startActivity(Intent(this, ListarFornecedores::class.java))
                R.id.action_config -> {
                    // Abrir a tela de Configurações
                    startActivity(Intent(this, ConfiguracoesActivity::class.java))
                }
                R.id.action_sair -> {
                    LoginWS.sair(this)
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish() // destroi essa activity e volta pra anteiror
                }
            }

            true
        }

        navmenu.getHeaderView(0).nav_header_title.text = getSharedPreferences("LOGIN", Context.MODE_PRIVATE).getString("username", "")
        // AC07
        val context = this
        Thread({
            //verificar ws
            val listaDeProdutos = ProdutoWS.getProdutos(context)
            runOnUiThread {
                produtoAdapater = ProdutoAdapater(this@MainActivity, listaDeProdutos)
                // exibir os produtos no recyclerview
                rv_lista_produtos?.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = produtoAdapater
                }
            }
        }).start()

    }

    override fun onResume() {
        super.onResume()
        val mBuilder = NotificationCompat.Builder(this, "notid")
            .setSmallIcon(android.R.drawable.ic_delete) // notification icon
            .setContentTitle("Projeto APp") // title for notification
            .setContentText("Bem Vindo ao Sistema") // message for notification
            .setAutoCancel(true)
            .setPriority(Notification.PRIORITY_MAX)// clear notification after click

        val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        mNotificationManager?.notify(1, mBuilder.build())
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)


        // Parte da pesquisa do na Actionbar.
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

            // quando clicar na setinha de voltar, abrirar o Drawer
            android.R.id.home -> drawerLayout.openDrawer(Gravity.LEFT)

            R.id.action_atualizar -> {
                pb_atualizando_pesquisa.visibility = View.VISIBLE // fica visivel
                val context = this
                Handler().postDelayed(Runnable {
                    // AC07
                    Thread({
                        //verificar ws
                        val listaDeProdutos = ProdutoWS.getProdutos(context)
                        runOnUiThread {
                            produtoAdapater = ProdutoAdapater(context, listaDeProdutos)
                            // exibir os produtos no recyclerview
                            rv_lista_produtos?.apply {
                                layoutManager = LinearLayoutManager(context)
                                adapter = produtoAdapater
                            }
                            pb_atualizando_pesquisa.visibility = View.GONE // fica visivel
                        }
                    }).start()
                }, 5000) // 10 segundos
            }
        }

        return true
    }

}
