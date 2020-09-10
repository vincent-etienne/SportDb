package com.etienne.vincent.sportdb.presentation.teams

import com.etienne.vincent.sportdb.domain.entity.Team


interface TeamsViewContract {
    fun updateAutoCompletionList(list: List<String>)
    fun showTeams(teams: List<Team>)
    fun showError()
    fun showLoading()
    fun navigateToTeam(team: Team)
}