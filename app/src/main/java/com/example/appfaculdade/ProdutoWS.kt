package com.example.appfaculdade

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL
import okhttp3.*


object ProdutoWS {

    val host = "http://lucaskurata.pythonanywhere.com/produtos"

    inline fun <reified T> parseJson(json: String): T {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson(json, type)
    }

    fun getProdutos(context: Context): MutableList<Produto> {
        if (isInternetDisponivel(context)) {
            val json = URL(host).readText()
            val produtos = parseJson(json) as MutableList<Produto>?
            produtos?.forEach {
                if (it.id != null && it.produto != null) {
                    salvarProdutoOffline(context, it)
                }
            }
            //mostra a notificação
            if (!produtos.isNullOrEmpty()) {
                Notificacao.mostrarNotificacao(context, "Listar Produtos", "${produtos.size} Produtos Carregados do WS")
                return produtos
            }
            return ArrayList<Produto>()

        } else {
            val dao = DatabaseManger.getDatabase(context)?.produtoDAO()
            dao?.let {
                return it.findAll()
            }
            return ArrayList<Produto>()
        }
    }

    fun isInternetDisponivel(context: Context): Boolean {
        val conexao = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val redes = conexao.allNetworks
        return redes.map { conexao.getNetworkInfo(it) }.any { it?.state == NetworkInfo.State.CONNECTED }
    }

    fun salvarProdutoOffline(context: Context, produto: Produto): Boolean {
        val dao = DatabaseManger.getDatabase(context)?.produtoDAO()
        if (!existeProduto(produto, context))
            dao?.let {
                it.insert(produto)
                return true
            }
        return false
    }

    fun existeProduto(produto: Produto, context: Context): Boolean {
        val dao = DatabaseManger.getDatabase(context)?.produtoDAO()
        return dao?.findProdutoById(produto.id) != null
    }

    fun save(produto: Produto, context: Context): String {
        if (isInternetDisponivel(context)) {
            val client = OkHttpClient()
            val requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), produto.toJson())
            val request = Request.Builder().url(host).post(requestBody).build()
            val response = client.newCall(request).execute()
            response.body()?.let {
                return it.toString()
            }
        } else {
            val salvo = salvarProdutoOffline(context, produto)
            if (salvo) {
                return "produto salvo : ${produto.toString()}"
            }
        }
        return ""
    }

    fun delete(produto: Produto, context: Context) {
        val dao = DatabaseManger.getDatabase(context)?.produtoDAO()
        if (existeProduto(produto, context))
            dao?.let {
                it.delete(produto)
            }
    }
}