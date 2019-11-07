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
import kotlinx.android.synthetic.main.fornecedor_item.view.iv_fornecedor_logo
import kotlinx.android.synthetic.main.protudo_item.view.*


// Para usar no recycler view
class FornecedorAdapter(private val context: Context, var listaDeFornecedores: MutableList<Fornecedor>) : RecyclerView.Adapter<FornecedorAdapter.ProdutoItemViewHolder>() {


    // cria a tela do item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoItemViewHolder {
        return ProdutoItemViewHolder(LayoutInflater.from(context).inflate(R.layout.fornecedor_item, parent, false))
    }

    // quantidade de items
    override fun getItemCount(): Int {
        return listaDeFornecedores.size
    }

    // mexer na view de produto_item
    override fun onBindViewHolder(holder: ProdutoItemViewHolder, position: Int) {
        // pegar um produto da lista
        val fornecedor = listaDeFornecedores.get(position)
        holder.view.tv_fornecedor_codigo.text = "Cor: ${fornecedor.codigo}"
        holder.view.tv_fornecedor_nome.text = "Nome: ${fornecedor.nome}"
        holder.view.tv_fornecedor_endereco.text = "Endereço: ${fornecedor.endereco}, ${fornecedor.cidade} - ${fornecedor.estado}"
        holder.view.iv_delete_fornecedor.setOnClickListener {
            Thread {
                val dao = DatabaseManger.getDatabase(context)?.fornecedorDAO()
                dao?.let {
                    if (it.findFornecedorById(fornecedor.id) != null) {
                        it.delete(fornecedor)
                    }
                }

            }.start()

            Toast.makeText(context, "Fornecedor Deletado", Toast.LENGTH_LONG).show()
            notifyItemRemoved(position)
            // notifyDataSetChanged() // atualiza a lista
        }
        fornecedor.foto?.let {
            val bitmap = stringParaBitmap(it)
            if (bitmap != null)
                holder.view.iv_fornecedor_logo.setImageBitmap(bitmap)
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