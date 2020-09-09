package com.etienne.vincent.sportdb.presentation.teams

import com.etienne.vincent.sportdb.domain.entity.Team


interface TeamsViewContract {
    fun showTeams(teams: List<Team>)
    fun showError()
    fun showLoading()
}