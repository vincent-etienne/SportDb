package com.etienne.vincent.sportdb.data.remote.repository

import com.etienne.vincent.sportdb.data.local.LocalDataSource
import com.etienne.vincent.sportdb.data.remote.datasource.RemoteDataSource
import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.repository.SportDbRepository


class SportDbRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : SportDbRepository {
    override suspend fun getAllTeam(team: String): GetAllTeam {
        return remoteDataSource.getAllTeam(team)
    }

    override suspend fun getAllLeagues(): GetAllLeagues {
        return remoteDataSource.getAllLeagues()
    }
}