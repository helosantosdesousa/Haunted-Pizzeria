package com.github.helosantosdesousa.hauntedpizzaria

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class User(val nickname: String, val score: Int)

class RankingAdapter(private val userList: List<User>) : RecyclerView.Adapter<RankingAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.userName)
        val scoreTextView: TextView = itemView.findViewById(R.id.userScore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ranking, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.nameTextView.text = user.nickname
        holder.scoreTextView.text = user.score.toString()
    }

    override fun getItemCount(): Int = userList.size
}

