package com.azkifairuz.jetherolist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.azkifairuz.jetherolist.model.Hero
import com.azkifairuz.jetherolist.repo.HeroRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class JetHeroesViewModel(private val repository: HeroRepository): ViewModel() {
    private val _groupedHeroes = MutableStateFlow(
        repository.getHeroes()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )

    val groupedHeroes: StateFlow<Map<Char,List<Hero>>> get() =  _groupedHeroes

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query
    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedHeroes.value = repository.searchHeroes(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }
}