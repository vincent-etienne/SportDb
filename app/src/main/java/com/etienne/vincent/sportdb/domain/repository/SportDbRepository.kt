package com.etienne.vincent.sportdb.domain.repository

import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.entity.GetPlayers


interface SportDbRepository {
    suspend fun getAllTeam(leagueName: String) : GetAllTeam
    suspend fun getAllLeagues() : GetAllLeagues
    suspend fun getPlayers(teamName: String): GetPlayers
}