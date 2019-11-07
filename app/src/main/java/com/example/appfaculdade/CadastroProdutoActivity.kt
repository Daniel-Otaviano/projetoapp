package com.example.appfaculdade

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_cadastro_fornecedor.*
import kotlinx.android.synthetic.main.activity_produto.*
import kotlinx.android.synthetic.main.toolbar.*
import java.io.ByteArrayOutputStream

class CadastroProdutoActivity : AppCompatActivity() {

    private val REQUEST_IMAGE_CAPTURE = 19
    private var fotoString = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)

        setSupportActionBar(app_toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // salvar novo produto
        val context = this
        bt_salvar_produto.setOnClickListener {

            val nome = et_produto_nome.text.toString()
            val cor = et_produto_cor.text.toString()
            val tamanho = et_produto_tamanho.text.toString()
            val id = et_produto_id.text.toString()
            // criar um metodo post no service

            Thread {
                //verificar ws
                // ProdutoWS.salvarProdutoOffline(context, Produto(cor, id.toInt(), nome, tamanho.toInt(), fotoString))
                ProdutoWS.save(Produto(cor, id.toInt(), nome, tamanho.toInt(), fotoString), context)
                runOnUiThread {
                    startActivity(Intent(this@CadastroProdutoActivity, MainActivity::class.java))
                }
            }.start()

        }


        // tirar foto
        bt_tirarfoto_produto.setOnClickListener {
            // verificar permissao no android
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                // pede permissao ao android
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA),
                    REQUEST_IMAGE_CAPTURE
                )
            } else {
                // ja tenho permissão
                tirarFotoFornecedor()
            }
        }


    }


    // verificar o resultado do pedido de permissão
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                //permissão ok
                tirarFotoFornecedor()
            } else {
                // sem permissão
            }
        }
    }


    fun tirarFotoFornecedor() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap // pega a imagem que foi tirada
            fotoString = bitmapParaString(imageBitmap) // converte a imagem para string
            iv_produto_foto.setImageBitmap(imageBitmap)
        }
    }

    // coverter bitimap para string
    fun bitmapParaString(foto: Bitmap): String {
        val byteArray = ByteArrayOutputStream()
        foto.compress(Bitmap.CompressFormat.JPEG, 100, byteArray)
        return Base64.encodeToString(byteArray.toByteArray(), Base64.DEFAULT)
    }

}
