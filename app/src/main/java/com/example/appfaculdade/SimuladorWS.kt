package com.example.appfaculdade

import android.content.Intent
import android.util.Log

// simular um webservice
class SimuladorWS {

    companion object {

        var usuarioLogado: Usuario? = null // não está logado

        val produtos = listarProdutos()

        fun logar(nomeUsuario: String, senha: String): Boolean {
            if (nomeUsuario.equals("aluno") && senha.equals("impacta")) {
                usuarioLogado = Usuario("Usuário Logado", nomeUsuario, senha) // fica logado
                return true // deu certo
            }
            // login errado
            return false
        }

        // simular lita os produtos
        fun listarProdutos(): ArrayList<Produto> {
            val listaSimulada = arrayListOf<Produto>()
            listaSimulada.add(Produto("Lápis de Cor 24 cores sextavado Evolution", 10))
            listaSimulada.add(Produto("Caneta esferográfica 1.2mm 4 cores", 20))
            listaSimulada.add(Produto("Cola branca 100g lavável 02810", 15))
            listaSimulada.add(Produto("Caderno Universitário Capa Dura 20x1 400", 6))
            listaSimulada.add(Produto("Lapiseira 0.7mm graphgear azul", 8))
            listaSimulada.add(Produto("Caneta Escreve e Apaga Frixion 0,7mm", 5))


            return listaSimulada
        }


        // simular cadastro
        fun cadastrar(produto: Produto?) {
            produto?.let {
                produtos.add(produto)
            }
        }
    }

}