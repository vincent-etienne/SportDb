package com.etienne.vincent.sportdb.data.remote.datasource

import com.etienne.vincent.sportdb.data.remote.SportsDbApi
import com.etienne.vincent.sportdb.data.remote.responses.GetAllLeaguesResponse
import com.etienne.vincent.sportdb.data.remote.responses.GetAllTeamResponse
import com.etienne.vincent.sportdb.data.remote.responses.GetPlayersResponse
import com.etienne.vincent.sportdb.domain.Listener
import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.entity.GetPlayers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RemoteDataSourceImpl(private val sportsDbApi: SportsDbApi) : RemoteDataSource{
    override fun getAllTeam(leagueName: String, listener: Listener<GetAllTeam>) {
        sportsDbApi.getAllTeam(leagueName).enqueue(object : Callback<GetAllTeamResponse>{
            override fun onFailure(call: Call<GetAllTeamResponse>, t: Throwable) {
                listener.onError()
            }
            override fun onResponse(call: Call<GetAllTeamResponse>, response: Response<GetAllTeamResponse>) {
                response.body()?.let { listener.onSuccess(it.toEntity()) } ?: listener.onError()
            }
        })
    }

    override fun getAllLeagues(listener: Listener<GetAllLeagues>) {
        sportsDbApi.getAllLeagues().enqueue(object : Callback<GetAllLeaguesResponse>{
            override fun onFailure(call: Call<GetAllLeaguesResponse>, t: Throwable) {
                listener.onError()
            }
            override fun onResponse(call: Call<GetAllLeaguesResponse>, response: Response<GetAllLeaguesResponse>) {
                response.body()?.let { listener.onSuccess(it.toEntity()) } ?: listener.onError()
            }
        })
    }

    override fun getPlayers(teamName: String, listener: Listener<GetPlayers>) {
        sportsDbApi.getPlayers(teamName).enqueue(object : Callback<GetPlayersResponse>{
            override fun onFailure(call: Call<GetPlayersResponse>, t: Throwable) {
                listener.onError()
            }
            override fun onResponse(call: Call<GetPlayersResponse>, response: Response<GetPlayersResponse>) {
                response.body()?.let { listener.onSuccess(it.toEntity()) } ?: listener.onError()
            }
        })
    }
}