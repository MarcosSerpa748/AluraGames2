import br.com.Alura.AluGames.Modelos.Periodo
import br.com.Alura.AluGames.Servicoa.RequisicaoAPI
import java.time.LocalDate

fun main(){

    val listaGamer = RequisicaoAPI.buscaListaGamer()
    val listaJogos = RequisicaoAPI.listaJogoJson()

    val gamer1 = listaGamer.get(3)
    val jogo1 = listaJogos.get(10)
    val jogo2 = listaJogos.get(4)
    val jogo3 = listaJogos.get(8)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(4))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(8))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(2))


    gamer1.alugarJogo(jogo1,periodo2)
    gamer1.alugarJogo(jogo3,periodo1)
    gamer1.alugarJogo(jogo2,periodo3)

    println(gamer1.jogosAlugados)


}