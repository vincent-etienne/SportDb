package com.etienne.vincent.sportdb.domain.entity


data class GetPlayers(
    val players: List<Player>
){
    companion object {
        val ERROR = GetPlayers(players = arrayListOf())
    }
}