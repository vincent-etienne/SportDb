package com.etienne.vincent.sportdb.presentation.players

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.etienne.vincent.sportdb.R
import com.etienne.vincent.sportdb.common.MarginItemDecoration
import com.etienne.vincent.sportdb.common.toPx
import com.etienne.vincent.sportdb.domain.entity.Player
import com.etienne.vincent.sportdb.domain.entity.Team
import com.etienne.vincent.sportdb.presentation.BaseActivity
import kotlinx.android.synthetic.main.players_activity.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class PlayersActivity : BaseActivity(), PlayersViewContract {

    override val presenter: PlayersPresenter by inject { parametersOf(teamName, this) }
    private val teamName: String by lazy { intent.getStringExtra(EXTRA_TEAM_NAME) }

    private val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    private val listAdapter = PlayersAdapter()

    companion object {
        private const val EXTRA_TEAM_NAME = "EXTRA_TEAM_NAME"
        fun newIntent(context: Context, team: Team) = Intent(context, PlayersActivity::class.java).apply {
            putExtra(EXTRA_TEAM_NAME, team.name)
        }
    }

    override fun initUI() {
        players_recycler_view.apply {
            layoutManager = this@PlayersActivity.layoutManager
            adapter = listAdapter
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.players_activity)
    }

    override fun showPlayers(players: List<Player>) {
        listAdapter.data = players
        players_loader.isVisible = false
    }

    override fun showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        players_loader.isVisible = false
    }

    override fun showLoading() {
        players_loader.isVisible = true
    }
}