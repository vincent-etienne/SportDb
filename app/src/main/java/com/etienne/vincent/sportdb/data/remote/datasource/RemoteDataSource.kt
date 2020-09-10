package com.etienne.vincent.sportdb.data.remote.datasource

import com.etienne.vincent.sportdb.domain.Listener
import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.entity.GetPlayers


interface RemoteDataSource {
    fun getAllTeam(leagueName: String, listener: Listener<GetAllTeam>)
    fun getAllLeagues(listener: Listener<GetAllLeagues>)
    fun getPlayers(teamName: String, listener: Listener<GetPlayers>)
}