package com.example.appfaculdade

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "produtos")
class Produto(var cor: String, @PrimaryKey var id: Int, var produto: String, var tamanho: Int, var foto:String?) : Serializable {

    // converte para Json
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}