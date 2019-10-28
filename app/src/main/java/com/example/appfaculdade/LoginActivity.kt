package com.example.appfaculdade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlin.concurrent.thread

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        // Quando o botaão da tela de login for clicado
        bt_login_entrar.setOnClickListener {

            val usuario = et_login_usuario.text.toString()
            val senha = et_login_senha.text.toString()
            val manterLogado = cb_manter_logado.isChecked

            val context = this
            Thread({
                val usuarioLogado = LoginWS.getUsuario(context, usuario, senha)
                runOnUiThread {
                    // consegui logar
                    if (usuarioLogado != null) {
                        if (manterLogado) {
                            LoginWS.permanecerLogado(usuarioLogado, manterLogado, context)
                        }
                        val intent = Intent(context, MainActivity::class.java)
                        // chama a outra tela
                        startActivity(intent)
                    } else {
                        Toast.makeText(context, "Falha ao Logar, senha ou usuario, incorreto(s)", Toast.LENGTH_SHORT).show()
                    }
                }
            }).start()
        }
    }

    override fun onResume() {
        super.onResume()
        if (LoginWS.isLogado(this)) {
            val intent = Intent(this, MainActivity::class.java)
            // chama a outra tela
            startActivity(intent)
        }
    }

}
