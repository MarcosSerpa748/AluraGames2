package br.com.Alura.AluGames.Modelos

import br.com.Alura.AluGames.utiltario.Recomendavel
import java.time.LocalDate
import java.util.Scanner
import kotlin.random.Random

data class Gamer(var nome:String,var email:String):Recomendavel{
    var dataNascimento:String? = null
    var usuario:String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrEmpty()){
                gerarID()
            }
        }
    var idInterno:String? = null
        private set
    
    var plano: Plano = PlanoAvulso("BRONZE")

    val jogosBuscados = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Aluguel>()
    val listaNotas = mutableListOf<Int>()
    val jogosRecomendados = mutableListOf<Jogo>()

    var id = 0

    fun validarEmail():String{
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(this.email)){
            return email
        }else{
            throw IllegalArgumentException("Email inválido!")
        }
    }

    init {
        if (nome.isNullOrBlank()){
            throw IllegalArgumentException("Nome inválido!")
        }
        validarEmail()
    }

    constructor(nome: String,email: String,dataDeNascimento:String,usuario:String) : this(nome, email){
        this.dataNascimento = dataDeNascimento
        this.usuario = usuario
        gerarID()
    }

    private fun gerarID(){
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d",numero)
        this.idInterno = "$usuario#$tag"
    }

    companion object{
        fun criarGamer(sc:Scanner): Gamer {
            println("Insira seu nome:")
            val nome = sc.nextLine()
            println("Insira seu email:")
            val email = sc.nextLine()

            println("Você deseja inserir data de nascimento e usuário?(S/N)")
            val resposta = sc.nextLine()
            if (resposta.equals("s",true)){
                println("Insira sua data de nascimento:")
                val dataDeNascimento = sc.nextLine()
                println("Insira seu usuário:")
                val usuario =  sc.nextLine()

                return Gamer(nome,email,dataDeNascimento,usuario)
            }else{
                return Gamer(nome, email)
            }
        }
    }
    fun alugarJogo(jogo: Jogo, dataInicial:LocalDate,dataFinal:LocalDate): Aluguel {
        val aluguel = Aluguel(this,jogo,dataInicial,dataFinal)
        jogosAlugados.add(aluguel)
        return aluguel

    }
    override fun toString(): String {
        return "Nome:$nome\n"+
                "Email:$email\n"+
                "DataNascimento:$dataNascimento\n"+
                "Usuário:$usuario\n"+
                "ID:$idInterno\n"+
                "AvaliaçãoMédia:$media\n" +
                "id:$id"
    }

    fun filtroDeMes(mes:Int): List<Aluguel> {
        return jogosAlugados
            .filter { aluguel ->  aluguel.dataIncial.monthValue == mes}
    }

    override val media: Double
        get() = listaNotas.average()

    override fun avaliar(nota: Int) {
        if (nota >= 1 && nota <= 10) {
            listaNotas.add(nota)
        }else{
            throw IllegalArgumentException("Número inválido!")
        }
    }
    fun recomendar(jogo: Jogo,nota:Int){
        jogosRecomendados.add(jogo)
        //jogo.avaliar(nota)
    }
}
