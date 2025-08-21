package br.com.Alura.AluGames.banco

import br.com.Alura.AluGames.Modelos.Jogo
import br.com.Alura.AluGames.Modelos.JogoEntity

class JogoDAO {
    fun getList():List<Jogo>{
        val menager = Banco.getEntityMenager()
        try {
            val query = menager.createQuery("From JogoEntity",JogoEntity::class.java)
            return query.resultList.map { jogoEntity ->Jogo(jogoEntity.titulo,jogoEntity.capa,jogoEntity.preco,jogoEntity.descricao)  }
        }finally {
            menager.close()
        }
    }
//    fun getList(): List<Jogo> {
//        val lista = mutableListOf<Jogo>()
//        val conexao = obterConexao()
//
//        if (conexao != null){
//            try {
//                val statement = conexao.createStatement()
//                val busca = statement.executeQuery("SELECT*FROM jogo")
//                while (busca.next()){
//                    val id = busca.getInt("id")
//                    val titulo = busca.getString("titulo")
//                    val descricao = busca.getString("descricao")
//                    val capa = busca.getString("capa")
//                    val preco = busca.getDouble("preco")
//
//                    val jogo = Jogo(titulo,descricao,preco,capa,id)
//                    lista.add(jogo)
//                }
//                statement.close()
//            }finally {
//                conexao.close()
//            }
//        }
//        return lista
//    }
//
//
//    fun inserirDado(jogo:Jogo){
//        val conexao = Banco.obterConexao()
//
//        if (conexao != null){
//            try {
//                val statement = conexao.prepareStatement("INSERT INTO JOGO (TITULO, CAPA, PRECO, DESCRICAO) VALUES (?, ?, ?, ?)")
//                statement.setString(1,jogo.titulo)
//                statement.setString(2,jogo.capa)
//                statement.setDouble(3,jogo.preco)
//                statement.setString(4,jogo.descricao)
//
//                statement.executeUpdate()
//            }finally {
//                conexao.close()
//            }
//
//        }
//
//    }
}