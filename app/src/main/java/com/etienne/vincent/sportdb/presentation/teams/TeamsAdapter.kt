package com.etienne.vincent.sportdb.presentation.teams

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.etienne.vincent.sportdb.R
import com.etienne.vincent.sportdb.domain.entity.Team
import kotlinx.android.synthetic.main.team_view_holder.view.*


class TeamsAdapter(
    private val listener: (Team) -> Unit
) : RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {

    private val _data = arrayListOf<Team>()
    var data: List<Team>
        get() = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.team_view_holder, parent, false)
        return ViewHolder(parent.context, itemView)
    }

    override fun getItemCount() = _data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = _data[position]

        holder.itemView.setOnClickListener { listener.invoke(model) }
        holder.bindItem(model)
    }

    class ViewHolder(
        val context: Context,
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(model: Team) {
            with(itemView) {
                Glide.with(this)
                    .load(model.imageUrl)
//                    .placeholder(R.drawable.ic_team_placeholder)
//                    .error(R.drawable.ic_team_error)
                    .into(team_vh_img)
            }
        }
    }
}