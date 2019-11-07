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
import androidx.room.*
import okhttp3.*


@Database(entities = arrayOf(Produto::class, Fornecedor::class), version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun produtoDAO(): ProdutoDAO
    abstract fun fornecedorDAO(): FornecedorDAO

}

object DatabaseManger {

    private var dbInstance: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase? {
        dbInstance?.let {
            return it
        }
        dbInstance = Room.databaseBuilder(context, AppDatabase::class.java, "projetoapp").build()
        return dbInstance
    }

    fun getProdutoDAO(): ProdutoDAO? {
        return dbInstance?.produtoDAO()
    }

    fun getFornecedorDAO(): ProdutoDAO? {
        return dbInstance?.produtoDAO()
    }
}