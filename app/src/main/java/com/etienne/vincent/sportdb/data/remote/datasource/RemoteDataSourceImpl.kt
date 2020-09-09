package com.etienne.vincent.sportdb.data.remote.datasource

import com.etienne.vincent.sportdb.data.remote.SportsDbApi
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam


class RemoteDataSourceImpl(private val sportsDbApi: SportsDbApi) : RemoteDataSource{
    override suspend fun getAllTeam(team: String): GetAllTeam {
        val response = sportsDbApi.getAllTeam(team)
        return when {
            response.isSuccessful -> response.body()?.toEntity() ?: GetAllTeam.ERROR
            else -> GetAllTeam.ERROR
        }
    }
}