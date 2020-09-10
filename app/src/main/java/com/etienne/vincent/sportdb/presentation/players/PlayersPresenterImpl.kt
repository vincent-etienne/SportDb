package com.etienne.vincent.sportdb.presentation.players

import com.etienne.vincent.sportdb.domain.Listener
import com.etienne.vincent.sportdb.domain.entity.GetPlayers
import com.etienne.vincent.sportdb.domain.usecase.GetPlayersUseCase
import kotlinx.coroutines.CoroutineDispatcher

class PlayersPresenterImpl(
    private val teamName: String,
    private val view: PlayersViewContract,
    private val getPlayersUseCase: GetPlayersUseCase
) : PlayersPresenter {

    override fun onStart() {
        getPlayersUseCase.invoke(teamName, object : Listener<GetPlayers>{
            override fun onSuccess(entity: GetPlayers) {
                view.showPlayers(entity.players)
            }

            override fun onError() {
                view.showError()
            }
        })
    }
}