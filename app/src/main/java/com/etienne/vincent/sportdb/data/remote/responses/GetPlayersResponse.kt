package com.etienne.vincent.sportdb.data.remote.responses

import com.etienne.vincent.sportdb.domain.entity.*
import com.google.gson.annotations.SerializedName


data class GetPlayersResponse(
    @SerializedName("player")
    val player: List<PlayerRemote>
){
    fun toEntity(): GetPlayers {
        return GetPlayers(status = GenericStatus.SUCCESS, players = player.map { remote ->
            Player(
                id = remote.idPlayer ?: -1,
                name = remote.name ?: "",
                position = remote.position ?: "",
                dateBorn = remote.dateBorn ?: "",
                signingAmount = remote.signingAmount ?: "",
                imageUrl = remote.imageUrl ?: ""
            )
        })
    }
}

data class PlayerRemote(
    @SerializedName("idPlayer")
    val idPlayer: Int?,
    @SerializedName("strPlayer")
    val name: String?,
    @SerializedName("dateBorn")
    val dateBorn: String?,
    @SerializedName("strPosition")
    val position: String?,
    @SerializedName("strSigning")
    val signingAmount: String?,
    @SerializedName("strThumb")
    val imageUrl: String?
)