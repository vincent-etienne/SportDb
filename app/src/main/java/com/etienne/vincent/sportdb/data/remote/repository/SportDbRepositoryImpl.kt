package com.etienne.vincent.sportdb.data.remote.repository

import com.etienne.vincent.sportdb.data.local.LocalDataSource
import com.etienne.vincent.sportdb.data.remote.datasource.RemoteDataSource
import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.entity.GetPlayers
import com.etienne.vincent.sportdb.domain.repository.SportDbRepository


class SportDbRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : SportDbRepository {
    override suspend fun getAllTeam(leagueName: String): GetAllTeam {
        return remoteDataSource.getAllTeam(leagueName)
    }

    override suspend fun getAllLeagues(): GetAllLeagues {
        return remoteDataSource.getAllLeagues()
    }

    override suspend fun getPlayers(teamName: String): GetPlayers {
        return remoteDataSource.getPlayers(teamName)
    }
}