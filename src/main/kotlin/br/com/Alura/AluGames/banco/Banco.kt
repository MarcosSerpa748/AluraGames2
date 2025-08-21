package br.com.Alura.AluGames.banco

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object Banco {

    fun getEntityMenager():EntityManager{
        val factory:EntityManagerFactory = Persistence.createEntityManagerFactory("alugames")

        return factory.createEntityManager()
    }

}