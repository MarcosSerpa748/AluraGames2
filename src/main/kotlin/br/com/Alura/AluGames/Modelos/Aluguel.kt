package br.com.Alura.AluGames.Modelos


data class Aluguel(val gamer: Gamer, val jogo: Jogo, val periodo: Periodo){

    val valorDoAluguel = jogo.preco*periodo.dias

    override fun toString(): String {
        return "Aluguel de ${jogo.titulo} por ${gamer.nome} pelo valor de R$$valorDoAluguel"
    }
}
