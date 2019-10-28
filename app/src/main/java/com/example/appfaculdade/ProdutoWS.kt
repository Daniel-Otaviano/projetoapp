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
object ProdutoWS {

    val host = "http://lucaskurata.pythonanywhere.com/produtos"

    inline fun <reified T> parseJson(json: String): T {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson(json, type)
    }

    fun getProdutos(context: Context): ArrayList<Produto> {
        if (isInternetDisponivel(context)) {
            val json = URL(host).readText()
            return parseJson(json)
        } else {
            return ArrayList<Produto>()
        }
    }

    fun isInternetDisponivel(context: Context): Boolean {
        val conexao = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val redes = conexao.allNetworks
        return redes.map { conexao.getNetworkInfo(it) }.any { it?.state == NetworkInfo.State.CONNECTED }
    }

    fun save(produto: Produto): String {
        val client = OkHttpClient()
        // val MIMEType = MediaType.get("application/json; charset=utf-8")
        val requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), produto.toJson())
        val request = Request.Builder().url(host).post(requestBody).build()
        val response = client.newCall(request).execute()
        response.body()?.let {
            return it.toString()
        }
        return ""
    }

}