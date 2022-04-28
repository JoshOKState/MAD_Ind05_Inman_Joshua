package com.example.mad_ind05_inman_joshua

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mad_ind05_inman_joshua.databinding.RecyclerviewRowBinding

class MyAdapter(val stateList: List<State>, private val context: Context) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RecyclerviewRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(state: State) {
            binding.tvStateName.text = state.name
            binding.tvStateNickname.text = state.nickname
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RecyclerviewRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val state = stateList[position]
        holder.bindItem(state)
        holder.itemView.setOnClickListener {
            // Create our intent
            val intent = Intent(context, StateDetails::class.java)
            // Sending details about the selected state
            intent.putExtra("name", state.name)
            intent.putExtra("size", state.size)
            intent.putExtra("flagImageName", state.flagImageName)
            intent.putExtra("mapImageName", state.mapImageName)
            // Start the destination activity
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return stateList.size
    }
}