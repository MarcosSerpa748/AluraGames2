package org.example.br.com.Alura.AluGames.Modelos

data class Jogo(val titulo:String,val capa:String){
    var preco = 0.0
    var descricao:String? = null

    constructor(titulo: String, capa: String, preco: Double, descricao:String) : this(titulo,capa){
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "titulo:$titulo\n" +
                "capa:$capa\n" +
                "preço:$preco\n"+
                "descrição:$descricao\n"
    }
}
