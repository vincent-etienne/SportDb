package com.etienne.vincent.sportdb.presentation.players

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.etienne.vincent.sportdb.R
import com.etienne.vincent.sportdb.domain.entity.Player
import kotlinx.android.synthetic.main.player_view_holder.view.*
import kotlinx.android.synthetic.main.team_view_holder.view.*


class PlayersAdapter() : RecyclerView.Adapter<PlayersAdapter.ViewHolder>() {

    private val _data = arrayListOf<Player>()
    var data: List<Player>
        get() = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.player_view_holder, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = _data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = _data[position]

        holder.bindItem(model)
    }

    class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(model: Player) {
            with(itemView) {
                Glide.with(this)
                    .load(model.imageUrl)
                    .into(player_img)

                player_name.text = model.name
                player_position.text = model.position
                player_born_date.text = context.getString(R.string.player_born_date, model.dateBorn)
                player_prize.text = context.getString(R.string.player_signing_prize, model.signingAmount)
            }
        }
    }
}