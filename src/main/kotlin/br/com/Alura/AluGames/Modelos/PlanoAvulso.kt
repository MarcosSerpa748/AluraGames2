package br.com.Alura.AluGames.Modelos

import java.time.Period

class PlanoAvulso(tipo:String,id:Int = 0): Plano(tipo,id){

    override fun obterValor(aluguel: Aluguel): Double {
        var calculoOriginal = super.obterValor(aluguel)

        if (aluguel.gamer.media>7) {
            calculoOriginal -= calculoOriginal*0.1
        }
        return calculoOriginal
    }

    override fun toString(): String {
        return "tipo:$tipo\n" +
                "id:$id"
    }
}
