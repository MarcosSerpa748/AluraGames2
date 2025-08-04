package br.com.Alura.AluGames.Modelos

import java.time.LocalDate
import java.time.Period

class Periodo(dataInicial:LocalDate,dataFinal:LocalDate) {

    val dias = Period.between(dataInicial,dataFinal).days
}