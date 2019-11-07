package com.example.appfaculdade

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "fornecedores")
class Fornecedor(@PrimaryKey(autoGenerate = true) var id: Int, var nome: String, var codigo: Int, var cidade: String, var estado: String, var endereco: String, var foto:String?) : Serializable {

    // converte para Json
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}