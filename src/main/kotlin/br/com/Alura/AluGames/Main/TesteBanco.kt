package br.com.Alura.AluGames.Main

import br.com.Alura.AluGames.Modelos.Jogo
import br.com.Alura.AluGames.banco.JogoDAO

fun main(){
    val jogo = Jogo("Dandara","https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293",5.99,"Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")
    val jogoDAO = JogoDAO()
    //jogoDAO.inserirDado(jogo)
    val lista:List<Jogo> = jogoDAO.getList()

    println(lista)
}