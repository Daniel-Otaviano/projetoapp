package com.example.appfaculdade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bt_login_entrar.setOnClickListener {
            val usuario = et_login_usuario.text.toString()
            val senha = et_login_senha.text.toString()
            if (usuario.equals("aluno") && senha.equals("impacta")) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login ou Senha Incorretos", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
