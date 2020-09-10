package com.etienne.vincent.sportdb.presentation.teams

import com.etienne.vincent.sportdb.domain.entity.Team
import com.etienne.vincent.sportdb.presentation.BasePresenter


interface TeamsPresenter : BasePresenter{
    fun onClickTeam(team: Team)
    fun onSelectLeague(name: String)
}