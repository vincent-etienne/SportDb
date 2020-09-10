package com.etienne.vincent.sportdb.domain.entity


data class League(
    val id: Int,
    val name: String,
    val nameAlternate: String,
    val sport: Sport
)