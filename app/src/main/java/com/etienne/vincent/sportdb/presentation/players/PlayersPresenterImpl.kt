package com.etienne.vincent.sportdb.presentation.players

import com.etienne.vincent.sportdb.domain.entity.GenericStatus
import com.etienne.vincent.sportdb.domain.entity.Team
import com.etienne.vincent.sportdb.domain.usecase.GetAllLeaguesUseCase
import com.etienne.vincent.sportdb.domain.usecase.GetAllTeamUseCase
import com.etienne.vincent.sportdb.domain.usecase.GetPlayersUseCase
import com.etienne.vincent.sportdb.presentation.BasePresenterImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class PlayersPresenterImpl(
    private val teamName: String,
    private val view: PlayersViewContract,
    private val getPlayersUseCase: GetPlayersUseCase,
    dispatcher: CoroutineDispatcher
) : PlayersPresenter, BasePresenterImpl(dispatcher) {


    override fun onStart() {
        launch {
            val entity = getPlayersUseCase.invoke(teamName)
            when(entity.status){
                GenericStatus.SUCCESS -> view.showPlayers(entity.players)
                GenericStatus.ERROR -> view.showError()
            }
        }
    }

    override fun handleException() {
        view.showError()
    }
}