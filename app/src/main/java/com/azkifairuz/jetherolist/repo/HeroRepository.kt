package com.azkifairuz.jetherolist.repo

import com.azkifairuz.jetherolist.model.Hero
import com.azkifairuz.jetherolist.model.HeroesData

class HeroRepository {
    fun getHeroes(): List<Hero>  {
        return  HeroesData.heroes
    }

    fun searchHeroes(query: String): List<Hero>{
        return HeroesData.heroes.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}