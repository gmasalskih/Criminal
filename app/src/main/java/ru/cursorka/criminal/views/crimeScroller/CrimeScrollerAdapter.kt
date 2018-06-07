package ru.cursorka.criminal.views.crimeScroller

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.startActivity
import ru.cursorka.criminal.R
import ru.cursorka.criminal.helper.CRIME_ID
import ru.cursorka.criminal.helper.log
import ru.cursorka.criminal.helper.toPretty
import ru.cursorka.criminal.model.entities.Crime
import ru.cursorka.criminal.views.crimeViewer.CrimeViewerActivity

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
        val crime = itemList[position]
        holder.apply {
            title.text = crime.title
            date.text = crime.date.toPretty()
            itemView.setOnClickListener {
                it.context.startActivity<CrimeViewerActivity>(CRIME_ID to crime.id)
            }
        }
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = itemView.findViewById(R.id.crime_title)
        val date: TextView = itemView.findViewById(R.id.crime_date)
    }
}