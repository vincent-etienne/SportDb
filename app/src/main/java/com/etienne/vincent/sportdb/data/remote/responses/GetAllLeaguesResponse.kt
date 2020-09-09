package com.etienne.vincent.sportdb.data.remote.responses

import com.etienne.vincent.sportdb.domain.entity.*
import com.google.gson.annotations.SerializedName


data class GetAllLeaguesResponse(
    @SerializedName("leagues")
    val leagues: List<Leagueremote>
){
    fun toEntity(): GetAllLeagues {
        return GetAllLeagues(status = GenericStatus.SUCCESS, leagues = leagues.map { remote ->
            League(
                id = remote.idLeague,
                name = remote.name,
                nameAlternate = remote.nameAlternate ?: "",
                sport = when(remote.sport){
                    "Soccer" -> Sport.SOCCER
                    else -> Sport.UNKNOWN
                }
            )
        })
    }
}

data class Leagueremote(
    @SerializedName("idLeague")
    val idLeague: Int,
    @SerializedName("strLeague")
    val name: String,
    @SerializedName("strLeagueAlternate")
    val nameAlternate: String?,
    @SerializedName("strSport")
    val sport: String
)