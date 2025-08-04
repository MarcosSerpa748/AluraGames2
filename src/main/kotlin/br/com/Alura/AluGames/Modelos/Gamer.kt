package br.com.Alura.AluGames.Modelos

import java.util.Scanner
import kotlin.random.Random

data class Gamer(var nome:String,var email:String){
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
    val jogosBuscados = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Aluguel>()

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
    fun alugarJogo(jogo: Jogo, periodo: Periodo): Aluguel {
        val aluguel = Aluguel(this,jogo,periodo)
        jogosAlugados.add(aluguel)
        return aluguel

    }
    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuário=$usuario, id=$idInterno)"
    }


}
