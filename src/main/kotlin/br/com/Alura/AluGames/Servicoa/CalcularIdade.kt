package br.com.Alura.AluGames.Servicoa

import br.com.Alura.AluGames.Modelos.Gamer
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

class CalcularIdade {

    companion object{
        fun descobrirIdade( gamer: Gamer):Int{
            val formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            var idade = 0
            val dataNascimento = LocalDate.parse(gamer.dataNascimento,formatador)
            val hoje = LocalDate.now()

            idade = Period.between(dataNascimento,hoje).years
            return idade

        }
    }
}