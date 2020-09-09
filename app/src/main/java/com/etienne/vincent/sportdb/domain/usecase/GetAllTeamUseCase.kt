package com.etienne.vincent.sportdb.domain.usecase

import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.repository.SportDbRepository

class GetAllTeamUseCase(private val sportDbRepository: SportDbRepository) {

    suspend fun invoke(team: String): GetAllTeam {
        return sportDbRepository.getAllTeam(team)
    }
}