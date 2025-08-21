package br.com.Alura.AluGames.Modelos

import java.time.LocalDate

data class Aluguel(val gamer: Gamer, val jogo: Jogo, val dataIncial:LocalDate,val dataFinal:LocalDate,) {
    var id = 0

    val valorDoAluguel = gamer.plano.obterValor(this)

    override fun toString(): String {
        return "Aluguel de ${jogo.titulo} por ${gamer.nome} pelo valor de R$$valorDoAluguel\n" +
                "id:$id"
    }
}
