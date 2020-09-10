package com.etienne.vincent.sportdb.domain.entity


data class GetPlayers(
    val status: GenericStatus,
    val players: List<Player>
){
    companion object {
        val ERROR = GetPlayers(status = GenericStatus.ERROR, players = arrayListOf())
    }
}