package com.etienne.vincent.sportdb.presentation.players

import com.etienne.vincent.sportdb.domain.entity.Player


interface PlayersViewContract {
    fun showPlayers(players: List<Player>)
    fun showError()
    fun showLoading()
}