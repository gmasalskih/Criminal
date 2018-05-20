package ru.cursorka.criminal.views.crimeScroller

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
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
        holder.bind(itemList[position])
    }

    class Holder(private val view: View) : RecyclerView.ViewHolder(view), Logger {

        private lateinit var title:TextView
        private lateinit var date: TextView

        fun bind(item: Crime) {
            itemView.apply {
                findViewById<TextView>(R.id.crime_title).apply {
                    text = item.title
                    title = this
                }
                findViewById<TextView>(R.id.crime_date).apply {
                    text = item.date.toString()
                    date = this
                }
                setOnClickListener {
                    Toast.makeText(context, "${title.text}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}