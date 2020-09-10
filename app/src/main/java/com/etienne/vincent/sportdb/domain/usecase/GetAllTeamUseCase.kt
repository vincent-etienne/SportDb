package com.etienne.vincent.sportdb.domain.usecase

import com.etienne.vincent.sportdb.domain.Listener
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.repository.SportDbRepository

class GetAllTeamUseCase(private val sportDbRepository: SportDbRepository) {

    fun invoke(leagueName: String, listener: Listener<GetAllTeam>) {
        sportDbRepository.getAllTeam(leagueName, listener)
    }
}