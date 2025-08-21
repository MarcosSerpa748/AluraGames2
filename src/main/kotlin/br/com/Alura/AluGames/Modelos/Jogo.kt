package br.com.Alura.AluGames.Modelos

import br.com.Alura.AluGames.utiltario.Recomendavel
import javax.persistence.*
import kotlin.jvm.Transient

data class Jogo(val titulo:String,val capa:String,val preco:Double,val descricao:String):Recomendavel{
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
    @Transient
    val listaNotas = mutableListOf<Int>()

    override val media: Double
        get() = listaNotas.average()

    constructor(titulo: String, capa: String, preco: Double, descricao:String,id:Int):this(titulo,capa,preco, descricao){
        this.id = id
    }

    override fun toString(): String {
        return "titulo:$titulo\n" +
                "capa:$capa\n" +
                "preço:$preco\n"+
                "descrição:$descricao\n"+
                "Nota:$media\n" +
                "id:$id"
    }

    override fun avaliar(nota: Int) {
        listaNotas.add(nota)
    }


}
