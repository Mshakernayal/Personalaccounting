package com.example.personalaccounting.view.adatper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.personalaccounting.R
import com.example.personalaccounting.model.entity.AddSpendEntity

class AddSpendRecyclerAdapter(var addSpendEntities : List<AddSpendEntity>) : RecyclerView.Adapter<AddSpendRecyclerAdapter.AddSpendViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddSpendViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_daily_movement,parent,false)
        return AddSpendViewHolder(view)
    }

    override fun onBindViewHolder(holder: AddSpendViewHolder, position: Int) {

        val addSpendEntity = addSpendEntities[position]

        holder.getTxtItemRecyclerDailyMovementDetailsText().text = "مصروف"
        holder.getTxtItemRecyclerDailyMovementPriceText().text = addSpendEntity.totalMoney
        holder.getTxtItemRecyclerDailyMovementNoticeText().text = addSpendEntity.notice
    }

    override fun getItemCount(): Int = addSpendEntities.size

    fun setData(addSpendEntities : List<AddSpendEntity>)
    {
        this.addSpendEntities = addSpendEntities
        notifyDataSetChanged()
    }

    class AddSpendViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        private val txtItemRecyclerDailyMovementDetailsText = itemView.findViewById<TextView>(R.id.txtItemRecyclerDailyMovementDetailsText)
        private val txtItemRecyclerDailyMovementPriceText = itemView.findViewById<TextView>(R.id.txtItemRecyclerDailyMovementPriceText)
        private val txtItemRecyclerDailyMovementNoticeText = itemView.findViewById<TextView>(R.id.txtItemRecyclerDailyMovementNoticeText)

        fun getTxtItemRecyclerDailyMovementDetailsText() :TextView = txtItemRecyclerDailyMovementDetailsText
        fun getTxtItemRecyclerDailyMovementPriceText() :TextView = txtItemRecyclerDailyMovementPriceText
        fun getTxtItemRecyclerDailyMovementNoticeText() :TextView = txtItemRecyclerDailyMovementNoticeText
    }
}