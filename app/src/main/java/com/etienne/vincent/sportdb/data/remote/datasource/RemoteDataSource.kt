package com.etienne.vincent.sportdb.data.remote.datasource

import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam


interface RemoteDataSource {
    suspend fun getAllTeam(team: String) : GetAllTeam
    suspend fun getAllLeagues() : GetAllLeagues
}