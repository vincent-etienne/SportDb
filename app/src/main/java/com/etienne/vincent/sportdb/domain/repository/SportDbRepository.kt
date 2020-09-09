package com.etienne.vincent.sportdb.domain.repository

import com.etienne.vincent.sportdb.domain.entity.GetAllTeam


interface SportDbRepository {
    suspend fun getAllTeam(team: String) : GetAllTeam
}