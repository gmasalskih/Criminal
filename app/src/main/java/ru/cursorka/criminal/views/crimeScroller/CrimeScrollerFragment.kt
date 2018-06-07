package ru.cursorka.criminal.views.crimeScroller

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.support.v4.toast
import org.koin.android.ext.android.inject
import ru.cursorka.criminal.R
import ru.cursorka.criminal.helper.log.Logger
import ru.cursorka.criminal.helper.log.log
import ru.cursorka.criminal.model.entities.Crime

class CrimeScrollerFragment : Fragment(), ICrimeScroller.View, Logger, AnkoLogger {

    override val presenter: ICrimeScroller.Presenter by inject()
    private lateinit var recyclerView: RecyclerView
    private lateinit var crimeScrollerAdapter: RecyclerView.Adapter<CrimeScrollerAdapter.Holder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log()
        presenter.init(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        log()
        return inflater.inflate(R.layout.fragment_crime_scroller, container, false).apply {
            recyclerView = findViewById(R.id.fragment_crime_scroller_recycler_view)
        }
    }

    override fun setCrimes(crimes: List<Crime>) {
        log()
        crimeScrollerAdapter = CrimeScrollerAdapter(crimes)
    }

    override fun updateUI() {
        log()
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = crimeScrollerAdapter
        crimeScrollerAdapter.notifyDataSetChanged()

    }

    override fun showErr(msg: String) {
        log()
        toast(msg)
    }
}