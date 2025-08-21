package br.com.Alura.AluGames.Modelos

import java.time.Period

open class Plano(val tipo:String,var id:Int = 0){

    open fun obterValor(aluguel: Aluguel):Double{
        return aluguel.jogo.preco* Period.between(aluguel.dataIncial,aluguel.dataFinal).days
    }
}