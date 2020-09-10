package com.etienne.vincent.sportdb.domain.repository

import com.etienne.vincent.sportdb.domain.Listener
import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.entity.GetPlayers


interface SportDbRepository {
    fun getAllLeagues(listener: Listener<GetAllLeagues>)
    fun getAllTeam(leagueName: String, listener: Listener<GetAllTeam>)
    fun getPlayers(teamName: String, listener: Listener<GetPlayers>)
}