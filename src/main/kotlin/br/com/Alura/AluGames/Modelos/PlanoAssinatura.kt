package br.com.Alura.AluGames.Modelos

class PlanoAssinatura(tipo:String,id:Int,val mensalidade:Double,val jogosInclusos:Int,val desconto:Double):Plano(tipo,id){

    override fun obterValor(aluguel: Aluguel): Double {
        val limite = (aluguel.gamer.jogosAlugados.size)+1

        return if (limite <= jogosInclusos){
             0.0
        }else{
             var calculoOriginal = super.obterValor(aluguel)
            if (aluguel.gamer.media>7){
                calculoOriginal -= calculoOriginal*desconto
            }
            calculoOriginal
        }
    }

    override fun toString(): String {
        return "tipo:$tipo\n" +
                "mensalidade:$$mensalidade\n" +
                "jogosInclusos:$jogosInclusos\n" +
                "deconto:$desconto\n" +
                "id:$id"
    }
}