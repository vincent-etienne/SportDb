package com.etienne.vincent.sportdb.domain.usecase

import com.etienne.vincent.sportdb.domain.Listener
import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.entity.GetPlayers
import com.etienne.vincent.sportdb.domain.entity.Team
import com.etienne.vincent.sportdb.domain.repository.SportDbRepository

class GetPlayersUseCase(private val sportDbRepository: SportDbRepository) {

    fun invoke(teamName: String, listener: Listener<GetPlayers>) {
        sportDbRepository.getPlayers(teamName, listener)
    }
}