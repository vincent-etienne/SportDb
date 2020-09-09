package com.etienne.vincent.sportdb.domain.entity

import com.etienne.vincent.sportdb.domain.entity.GenericStatus


data class GetAllTeam(
    val status: GenericStatus,
    val teams: List<Team>
){
    companion object {
        val ERROR = GetAllTeam(status = GenericStatus.ERROR, teams = arrayListOf())
    }
}