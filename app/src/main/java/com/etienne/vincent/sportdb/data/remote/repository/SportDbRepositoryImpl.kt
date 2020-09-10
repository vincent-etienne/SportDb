package com.etienne.vincent.sportdb.data.remote.repository

import com.etienne.vincent.sportdb.data.local.LocalDataSource
import com.etienne.vincent.sportdb.data.remote.datasource.RemoteDataSource
import com.etienne.vincent.sportdb.domain.Listener
import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.entity.GetPlayers
import com.etienne.vincent.sportdb.domain.repository.SportDbRepository


class SportDbRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : SportDbRepository {
    override fun getAllTeam(leagueName: String, listener: Listener<GetAllTeam>) {
        remoteDataSource.getAllTeam(leagueName, listener)
    }

    override fun getAllLeagues(listener: Listener<GetAllLeagues>) {
        remoteDataSource.getAllLeagues(listener)
    }

    override fun getPlayers(teamName: String, listener: Listener<GetPlayers>) {
        remoteDataSource.getPlayers(teamName, listener)
    }
}