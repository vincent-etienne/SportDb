package com.etienne.vincent.sportdb.presentation.teams

import com.etienne.vincent.sportdb.domain.Listener
import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.entity.Team
import com.etienne.vincent.sportdb.domain.usecase.GetAllLeaguesUseCase
import com.etienne.vincent.sportdb.domain.usecase.GetAllTeamUseCase

class TeamsPresenterImpl(
    private val view: TeamsViewContract,
    private val getAllLeaguesUseCase: GetAllLeaguesUseCase,
    private val getAllTeamsUseCase: GetAllTeamUseCase
) : TeamsPresenter {


    override fun onStart() {
        getAllLeaguesUseCase.invoke(object : Listener<GetAllLeagues>{
            override fun onSuccess(entity: GetAllLeagues) {
                view.updateAutoCompletionList(entity.leagues.map { league -> league.name })
            }

            override fun onError() {
                view.showError()
            }
        })
    }

    override fun onSelectLeague(name: String) {
        view.showLoading()

        getAllTeamsUseCase.invoke(name, object : Listener<GetAllTeam>{
            override fun onSuccess(entity: GetAllTeam) {
                view.showTeams(entity.teams)
            }

            override fun onError() {
                view.showError()
            }
        })
    }
    override fun onClickTeam(team: Team) {
        view.navigateToTeam(team)
    }
}