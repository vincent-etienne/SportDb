package com.etienne.vincent.sportdb.data.remote

import com.etienne.vincent.sportdb.data.remote.responses.GetAllLeaguesResponse
import com.etienne.vincent.sportdb.data.remote.responses.GetAllTeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface SportsDbApi {

    @GET("api/v1/json/4013017/search_all_teams.php")
    suspend fun getAllTeam(@Query(value = "l") team: String): Response<GetAllTeamResponse>

    @GET("api/v1/json/4013017/all_leagues.php")
    suspend fun getAllLeagues(): Response<GetAllLeaguesResponse>
}