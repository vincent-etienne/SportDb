package com.etienne.vincent.sportdb.presentation.teams

import com.etienne.vincent.sportdb.domain.entity.GenericStatus
import com.etienne.vincent.sportdb.domain.entity.Team
import com.etienne.vincent.sportdb.domain.usecase.GetAllLeaguesUseCase
import com.etienne.vincent.sportdb.domain.usecase.GetAllTeamUseCase
import com.etienne.vincent.sportdb.presentation.BasePresenterImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class TeamsPresenterImpl(
    private val view: TeamsViewContract,
    private val getAllLeaguesUseCase: GetAllLeaguesUseCase,
    private val getAllTeamsUseCase: GetAllTeamUseCase,
    dispatcher: CoroutineDispatcher
) : TeamsPresenter, BasePresenterImpl(dispatcher) {


    override fun onStart() {
        launch {
            val entity = getAllLeaguesUseCase.invoke()
            when(entity.status){
                GenericStatus.SUCCESS -> view.updateAutoCompletionList(entity.leagues.map { league -> league.name })
                GenericStatus.ERROR -> view.showError()
            }
        }
    }

    override fun onSelectLeague(name: String) {
        view.showLoading()

        launch {
            val entity = getAllTeamsUseCase.invoke(name)
            when(entity.status){
                GenericStatus.SUCCESS -> view.showTeams(entity.teams)
                GenericStatus.ERROR -> view.showError()
            }
        }
    }
    override fun onClickTeam(team: Team) {
        view.navigateToTeam(team)
    }

    override fun handleException() {
        view.showError()
    }
}