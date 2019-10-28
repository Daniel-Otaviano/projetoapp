package com.example.appfaculdade

import com.google.gson.GsonBuilder

class Produto(var cor: String, var id: Int, var produto: String, var tamanho: Int) {

    // converte para Json
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}