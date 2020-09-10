package com.etienne.vincent.sportdb.domain.entity


data class GetAllTeam(
    val teams: List<Team>
){
    companion object {
        val ERROR = GetAllTeam(teams = arrayListOf())
    }
}