package com.etienne.vincent.sportdb.domain.usecase

import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.entity.GetPlayers
import com.etienne.vincent.sportdb.domain.entity.Team
import com.etienne.vincent.sportdb.domain.repository.SportDbRepository

class GetPlayersUseCase(private val sportDbRepository: SportDbRepository) {

    suspend fun invoke(teamName: String): GetPlayers {
        return sportDbRepository.getPlayers(teamName)
    }
}