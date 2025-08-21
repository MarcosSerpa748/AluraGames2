package br.com.Alura.AluGames.Modelos

import javax.persistence.*
@Entity
@Table(name = "jogo")
data class JogoEntity(val titulo: String = "Titulo do jogo",
                  val capa: String = "Capa do jogo",
                 val preco: Double = 0.0,
                 val descricao:String = "Descrição do jogo",
                 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                 val id:Int) {

}