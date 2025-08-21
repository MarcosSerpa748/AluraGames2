import br.com.Alura.AluGames.Modelos.Gamer
import br.com.Alura.AluGames.Modelos.PlanoAssinatura
import br.com.Alura.AluGames.Servicoa.RequisicaoAPI
import java.time.LocalDate
import java.util.*

fun main(){
    val sc = Scanner(System.`in`)
    val listaJogos = RequisicaoAPI.listaJogoJson()

    val gamer = Gamer.criarGamer(sc)

    val jogo1 = listaJogos.get(10)
    val jogo2 = listaJogos.get(4)
    val jogo3 = listaJogos.get(8)
    val jogo4 = listaJogos.get(1)

    gamer.alugarJogo(jogo1, LocalDate.of(2025,8,6), LocalDate.of(2025,8,11))
    gamer.alugarJogo(jogo2, LocalDate.of(2025,8,9), LocalDate.of(2025,8,12))
    gamer.alugarJogo(jogo3, LocalDate.of(2025,8,13), LocalDate.of(2025,8,16))
    gamer.alugarJogo(jogo4, LocalDate.of(2025,8,17), LocalDate.of(2025,8,20))

    gamer.recomendar(jogo1,7)
    gamer.recomendar(jogo1,8)

    println(gamer.jogosRecomendados)

}