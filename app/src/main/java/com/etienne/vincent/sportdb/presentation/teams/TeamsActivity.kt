package com.etienne.vincent.sportdb.presentation.teams

import android.os.Bundle
import android.widget.Toast
import com.etienne.vincent.sportdb.R
import com.etienne.vincent.sportdb.domain.entity.Team
import com.etienne.vincent.sportdb.presentation.BaseActivity
import com.etienne.vincent.sportdb.presentation.BasePresenter
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class TeamsActivity : BaseActivity(), TeamsViewContract {
    override val presenter: BasePresenter
        get() = teamsPresenter

    private val teamsPresenter : TeamsPresenter by inject { parametersOf(this) }

    override fun initUI() {
        teamsPresenter.onClickTeam(Team("", ""))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teams_activity)
    }

    override fun showTeams(teams: List<Team>) {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
    }

    override fun showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

    }

    override fun showLoading() {
        Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
    }
}