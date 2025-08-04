package org.example.br.com.Alura.AluGames.Main
import br.com.Alura.AluGames.Modelos.Gamer
import br.com.Alura.AluGames.Servicoa.RequisicaoAPI
import br.com.Alura.AluGames.Modelos.Jogo
import java.util.Scanner
fun main() {
    val sc = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(sc)
    do{
        println("Digite o ID do jogo:")
        val id = sc.nextLine()

        var meuJogo: Jogo? = null

        val resultado = runCatching {

            val infoRequisicao = RequisicaoAPI.buscaJogo(id)

            meuJogo = Jogo(infoRequisicao.info.title,infoRequisicao.info.thumb)
        }
        resultado.onFailure {
            println("ID inexistente, tente outro")
        }
        resultado.onSuccess {
            println("Você deseja inserir uma descrição ao jogo? S/N")
            val escolha = sc.nextLine()
            if (escolha.equals("s",true)){
                print("Digite sua descrição:")
                val descricao = sc.nextLine()
                meuJogo?.descricao = descricao
            }else{
                meuJogo?.descricao = meuJogo?.titulo
            }
        }
        gamer.jogosBuscados.add(meuJogo)
        println("Você deseja continuar a pesquisar jogos?(S/N)")
        val escolha = sc.nextLine()

    }while (escolha.equals("s",true))

    println("Lista de jogos:${gamer.jogosBuscados}")
}