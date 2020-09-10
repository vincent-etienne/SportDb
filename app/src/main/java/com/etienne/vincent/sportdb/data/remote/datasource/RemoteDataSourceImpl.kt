package com.etienne.vincent.sportdb.data.remote.datasource

import com.etienne.vincent.sportdb.data.remote.SportsDbApi
import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.entity.GetPlayers


class RemoteDataSourceImpl(private val sportsDbApi: SportsDbApi) : RemoteDataSource{
    override suspend fun getAllTeam(leagueName: String): GetAllTeam {
        val response = sportsDbApi.getAllTeam(leagueName)
        return when {
            response.isSuccessful -> response.body()?.toEntity() ?: GetAllTeam.ERROR
            else -> GetAllTeam.ERROR
        }
    }

    override suspend fun getAllLeagues(): GetAllLeagues {
        val response = sportsDbApi.getAllLeagues()
        return when {
            response.isSuccessful -> response.body()?.toEntity() ?: GetAllLeagues.ERROR
            else -> GetAllLeagues.ERROR
        }
    }

    override suspend fun getPlayers(teamName: String): GetPlayers {
        val response = sportsDbApi.getPlayers(teamName)
        return when {
            response.isSuccessful -> response.body()?.toEntity() ?: GetPlayers.ERROR
            else -> GetPlayers.ERROR
        }
    }
}