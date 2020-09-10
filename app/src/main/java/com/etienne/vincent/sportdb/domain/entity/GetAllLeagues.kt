package com.etienne.vincent.sportdb.domain.entity


data class GetAllLeagues(
    val status: GenericStatus,
    val leagues: List<League>
){
    companion object {
        val ERROR = GetAllLeagues(status = GenericStatus.ERROR, leagues = arrayListOf())
    }
}