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
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import okhttp3.*


@Dao
interface FornecedorDAO {

    @Insert
    fun insert(fornecedor: Fornecedor)

    @Delete
    fun delete(fornecedor: Fornecedor)

    @Query("SELECT * FROM fornecedores")
    fun findAll(): MutableList<Fornecedor>

    @Query("SELECT * FROM fornecedores WHERE id = :id")
    fun findFornecedorById(id: Int): Fornecedor

}