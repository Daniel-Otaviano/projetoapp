package com.example.appfaculdade

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL
import android.os.AsyncTask.execute
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import okhttp3.*


// simular um webservice
object LoginWS {

    val host = "http://lucaskurata.pythonanywhere.com/login/5"

    inline fun <reified T> parseJson(json: String): T {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson(json, type)
    }

    fun getUsuario(context: Context, user: String, senha: String): Usuario? {
        if (isInternetDisponivel(context)) {
            val json = URL(host).readText()
            val usuario = parseJson(json) as Usuario
            if (usuario.password.equals(senha) && usuario.user.equals(user)) {
                return usuario
            }
            return null
        } else {
            return null
        }
    }

    // salva logado ac07
    fun permanecerLogado(usuario: Usuario, logado: Boolean, context: Context) {
        val sessao = context.getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        sessao.edit().putBoolean("logado", logado).putString("username", usuario.user).putString("password", usuario.password).apply()
    }


    // apaga logado ac07
    fun sair(context: Context) {
        val sessao = context.getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        sessao.edit().putBoolean("logado", false).putString("username", "").putString("password","").apply()
    }

    fun isLogado(context: Context): Boolean {
        val sessao = context.getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        val logado = sessao.getBoolean("logado", false)
        return logado
    }

    fun isInternetDisponivel(context: Context): Boolean {
        val conexao = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val redes = conexao.allNetworks
        return redes.map { conexao.getNetworkInfo(it) }.any { it?.state == NetworkInfo.State.CONNECTED }
    }


}