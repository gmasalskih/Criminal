package ru.cursorka.criminal.views.crimeScroller

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.toast
import ru.cursorka.criminal.R
import ru.cursorka.criminal.helper.log.Logger
import ru.cursorka.criminal.helper.log.log
import ru.cursorka.criminal.model.entities.Crime

class CrimeScrollerAdapter(private val itemList: List<Crime>) : RecyclerView.Adapter<CrimeScrollerAdapter.Holder>(), Logger {
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
        holder.title.text = itemList[position].title
        holder.date.text = android.text.format.DateFormat.format("dd.MM.yyyy hh:mm", itemList[position].date)
        holder.apply {
            title.text = itemList[position].title
            date.text = android.text.format.DateFormat.format("dd.MM.yyyy hh:mm", itemList[position].date)
            itemView.setOnClickListener{
                it.context.toast("${title.text}")
            }
        }
    }

    class Holder(private val view: View) : RecyclerView.ViewHolder(view), Logger {
        val title: TextView = itemView.findViewById(R.id.crime_title)
        val date: TextView = itemView.findViewById(R.id.crime_date)
    }
}