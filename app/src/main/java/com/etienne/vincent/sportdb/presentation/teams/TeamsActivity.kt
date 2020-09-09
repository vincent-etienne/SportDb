package com.etienne.vincent.sportdb.presentation.teams

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.etienne.vincent.sportdb.R
import com.etienne.vincent.sportdb.common.MarginItemDecoration
import com.etienne.vincent.sportdb.common.toPx
import com.etienne.vincent.sportdb.domain.entity.Team
import com.etienne.vincent.sportdb.presentation.BaseActivity
import kotlinx.android.synthetic.main.teams_activity.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class TeamsActivity : BaseActivity(), TeamsViewContract {
    override val presenter: TeamsPresenter by inject { parametersOf(this) }

    private val layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
    private val listAdapter = TeamsAdapter { team -> presenter.onClickTeam(team)  }

    private val autoCompleteAdapter by lazy { ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, arrayListOf()) }

    override fun initUI() {
        teams_autocompletetextview.apply {
            setAdapter(autoCompleteAdapter)
            threshold = 1
            setOnItemClickListener { _, _, position, _ ->
                autoCompleteAdapter.getItem(position)?.let { presenter.onSelectLeague(it) }
            }
        }

        teams_recycler_view.apply {
            layoutManager = this@TeamsActivity.layoutManager
            adapter = listAdapter
            addItemDecoration(MarginItemDecoration(0, 16.toPx(), 0, 0))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teams_activity)
    }

    override fun updateAutoCompletionList(list: List<String>) {
        autoCompleteAdapter.addAll(list)
    }

    override fun showTeams(teams: List<Team>) {
        listAdapter.data = teams
        teams_loader.isVisible = false
    }

    override fun showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        teams_loader.isVisible = false
    }

    override fun showLoading() {
        teams_loader.isVisible = true
    }

    override fun navigateToTeam(team: Team) {

    }
}