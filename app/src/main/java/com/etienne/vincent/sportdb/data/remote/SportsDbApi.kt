package com.etienne.vincent.sportdb.data.remote

import com.etienne.vincent.sportdb.data.remote.responses.GetAllTeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface SportsDbApi {
    companion object{
        const val API_KEY = "4013017"
    }
    @GET("api/v1/json/{$API_KEY}/search_all_teams.php")
    suspend fun getAllTeam(@Query(value = "t") team: String): Response<GetAllTeamResponse>
}