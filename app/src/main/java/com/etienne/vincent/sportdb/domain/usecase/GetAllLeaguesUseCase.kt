package com.etienne.vincent.sportdb.domain.usecase

import com.etienne.vincent.sportdb.domain.Listener
import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.repository.SportDbRepository

class GetAllLeaguesUseCase(private val sportDbRepository: SportDbRepository) {

    fun invoke(listener: Listener<GetAllLeagues>) {
        return sportDbRepository.getAllLeagues(listener)
    }
}