package com.example.appfaculdade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class TelainicialActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telainicial)

        val params = intent.extras
        val nome = params?.getString("nome_usuario")
        val n = params?.getInt("numero")

        Toast.makeText(this, "Bem Vindo $nome",
            Toast.LENGTH_SHORT).show()

        supportActionBar?.title = "Disciplinas"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId

        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Clicou em Buscar",
                Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_atualizar){
            Toast.makeText (this, "Clicou em atualizar",
                Toast.LENGTH_SHORT).show()
        } else if (id == android.R.id.home) {
         finish()
        }



        return super.onOptionsItemSelected(item)
    }
}
