package com.example.appfaculdade

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fornecedor_item.view.*
import kotlinx.android.synthetic.main.protudo_item.view.*

// Para usar no recycler view
class ProdutoAdapater(private val context: Context, var listaDeProdutos: MutableList<Produto>) : RecyclerView.Adapter<ProdutoAdapater.ProdutoItemViewHolder>() {


    // cria a tela do item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoItemViewHolder {
        return ProdutoItemViewHolder(LayoutInflater.from(context).inflate(R.layout.protudo_item, parent, false))
    }

    // quantidade de items
    override fun getItemCount(): Int {
        return listaDeProdutos.size
    }

    // mexer na view de produto_item
    override fun onBindViewHolder(holder: ProdutoItemViewHolder, position: Int) {
        // pegar um produto da lista
        val produto = listaDeProdutos.get(position)
        holder.view.tv_produto_nome.text = "Nome: ${produto.produto}"
        holder.view.tv_produto_cor.text = "Cor: ${produto.cor}"
        holder.view.tv_produto_tam.text = "Tamanho: ${produto.tamanho}"
        holder.view.iv_delete_produto.setOnClickListener {
            Thread {
                ProdutoWS.delete(produto, context)
            }.start()
            Toast.makeText(context, "Produto Deletado", Toast.LENGTH_LONG).show()
            notifyDataSetChanged() // atualiza a lista
        }

        produto.foto?.let {
            val bitmap = stringParaBitmap(it)
            if (bitmap != null)
                holder.view.iv_produtoitem_logo.setImageBitmap(bitmap)
        }
    }


    //converter a string do bando de dados em imagem
    fun stringParaBitmap(fotoString: String): Bitmap? {
        val byteArray = Base64.decode(fotoString, Base64.DEFAULT)
        byteArray?.let {
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
        }
        return null
    }


    // usado para acessar a tela produto_item
    class ProdutoItemViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
    }

}