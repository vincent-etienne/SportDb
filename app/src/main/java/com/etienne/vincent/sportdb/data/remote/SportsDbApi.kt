package com.etienne.vincent.sportdb.data.remote

import com.etienne.vincent.sportdb.data.remote.responses.GetAllLeaguesResponse
import com.etienne.vincent.sportdb.data.remote.responses.GetAllTeamResponse
import com.etienne.vincent.sportdb.data.remote.responses.GetPlayersResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface SportsDbApi {

    @GET("api/v1/json/4013017/search_all_teams.php")
    fun getAllTeam(@Query(value = "l") leagueName: String): Call<GetAllTeamResponse>

    @GET("api/v1/json/4013017/all_leagues.php")
    fun getAllLeagues(): Call<GetAllLeaguesResponse>

    @GET("api/v1/json/4013017/searchplayers.php")
    fun getPlayers(@Query(value = "t") teamName: String): Call<GetPlayersResponse>
}