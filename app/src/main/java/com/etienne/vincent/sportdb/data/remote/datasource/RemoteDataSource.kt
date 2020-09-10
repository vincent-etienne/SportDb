package com.etienne.vincent.sportdb.data.remote.datasource

import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.entity.GetPlayers


interface RemoteDataSource {
    suspend fun getAllTeam(leagueName: String) : GetAllTeam
    suspend fun getAllLeagues() : GetAllLeagues
    suspend fun getPlayers(teamName: String): GetPlayers
}