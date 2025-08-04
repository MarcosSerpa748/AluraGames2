package org.example

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner


fun main() {
    val sc = Scanner(System.`in`)
    val busca = sc.nextLine()

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$busca"))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()
    val gson = Gson()

    var meuJogo:Jogo? = null

       val resultado = runCatching {
           val meuInfoJogo = gson.fromJson(json,InfoJogo::class.java)
           meuJogo = Jogo(meuInfoJogo.info.title,meuInfoJogo.info.thumb)
       }
    resultado.onFailure {
        println("ID inexistente, tente outro")
    }
    resultado.onSuccess {
        println("Voçê deseja inserir uma descrição ao jogo? S/N")
        val escolha = sc.nextLine().uppercase()
        if (escolha.equals("S")){
            print("Digite sua descrição:")
            val descricao = sc.nextLine()
            meuJogo?.descricao = descricao
        }else{
            meuJogo?.descricao = meuJogo?.titulo
        }
        println(meuJogo)
    }


}