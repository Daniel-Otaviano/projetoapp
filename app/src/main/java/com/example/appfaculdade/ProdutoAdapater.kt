package com.example.appfaculdade

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.protudo_item.view.*

// Para usar no recycler view
class ProdutoAdapater(private val context: Context, var listaDeProdutos: ArrayList<Produto>) : RecyclerView.Adapter<ProdutoAdapater.ProdutoItemViewHolder>() {


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
    }


    // usado para acessar a tela produto_item
    class ProdutoItemViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
    }

}