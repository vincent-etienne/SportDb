package com.etienne.vincent.sportdb.data.remote.responses

import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.entity.Team
import com.google.gson.annotations.SerializedName


data class GetAllTeamResponse(
    @SerializedName("teams")
    val teams: List<TeamRemote>
){
    fun toEntity(): GetAllTeam {
        return GetAllTeam(teams = teams.map { remote ->
            Team(
                name = remote.name ?: "",
                imageUrl = remote.imageUrl ?: ""
            )
        })
    }
}

data class TeamRemote(
    @SerializedName("idTeam")
    val idTeam: Int?,
    @SerializedName("strTeam")
    val name: String?,
    @SerializedName("strTeamBadge")
    val imageUrl: String?
)