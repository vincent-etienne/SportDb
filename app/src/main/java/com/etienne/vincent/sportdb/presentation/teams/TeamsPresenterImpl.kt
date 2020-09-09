package com.etienne.vincent.sportdb.presentation.teams

import com.etienne.vincent.sportdb.domain.entity.GenericStatus
import com.etienne.vincent.sportdb.domain.entity.Team
import com.etienne.vincent.sportdb.domain.usecase.GetAllTeamUseCase
import com.etienne.vincent.sportdb.presentation.BasePresenterImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class TeamsPresenterImpl(
    private val view: TeamsViewContract,
    private val getAllTeamsUseCase: GetAllTeamUseCase,
    dispatcher: CoroutineDispatcher
) : TeamsPresenter, BasePresenterImpl(dispatcher) {

    override fun onClickTeam(team: Team) {
        view.showLoading()
        launch {
            val entity = getAllTeamsUseCase.invoke("French Ligue 1")
            when(entity.status){
                GenericStatus.SUCCESS -> view.showTeams(entity.teams)
                GenericStatus.ERROR -> view.showError()
            }
        }
    }

    override fun handleException() {
        view.showError()
    }
}