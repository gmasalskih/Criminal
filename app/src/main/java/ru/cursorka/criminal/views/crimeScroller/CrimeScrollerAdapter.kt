package ru.cursorka.criminal.views.crimeScroller

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.cursorka.criminal.R
import ru.cursorka.criminal.helper.ext.*
import ru.cursorka.criminal.model.entities.Crime

class CrimeScrollerAdapter(private val itemList: List<Crime>) : RecyclerView.Adapter<CrimeScrollerAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        log()
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_crime_scroller, parent, false))
    }

    override fun getItemCount(): Int {
        log()
        return itemList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        log()
        holder.apply {
            mTitle.text = itemList[position].title
            mDate.text = itemList[position].date.toString()
            itemView.setOnClickListener {
                it.toast(mTitle.text.toString())
            }
        }
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val mTitle: TextView = itemView.findViewById(R.id.crime_title)
        val mDate: TextView = itemView.findViewById(R.id.crime_date)
    }
}