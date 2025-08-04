package br.com.Alura.AluGames.Servicoa

import br.com.Alura.AluGames.Modelos.Gamer
import br.com.Alura.AluGames.Modelos.Jogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.br.com.Alura.AluGames.Modelos.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class RequisicaoAPI {

    companion object {
        private fun requisicao(url:String): String {
            val client: HttpClient = HttpClient.newHttpClient()
            val request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build()
            val response = client
                .send(request, BodyHandlers.ofString())

            return response.body()
        }
        fun buscaJogo(id: String): InfoJogo {
            val url = "https://www.cheapshark.com/api/1.0/games?id=$id"
            val json = requisicao(url)
            val gson = Gson()
            val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

            return meuInfoJogo

        }
        fun buscaListaGamer(): List<Gamer> {
            val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
            val json = requisicao(url)
            val gson = Gson()

            val tipoNecessario = object : TypeToken<List<Gamer>>() {}.type
            val lista: List<Gamer> = gson.fromJson(json, tipoNecessario)

            return lista
        }
        fun listaJogoJson():List<Jogo>{
            val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"

            val json = requisicao(url)
            val gson = Gson()

            val tipoNecessario = object:TypeToken<List<Jogo>>(){}.type
            val lista:List<Jogo> = gson.fromJson(json,tipoNecessario)

            return lista
        }
    }
}