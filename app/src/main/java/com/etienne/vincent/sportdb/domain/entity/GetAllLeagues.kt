package com.etienne.vincent.sportdb.domain.entity


data class GetAllLeagues(
    val leagues: List<League>
){
    companion object {
        val ERROR = GetAllLeagues(leagues = arrayListOf())
    }
}