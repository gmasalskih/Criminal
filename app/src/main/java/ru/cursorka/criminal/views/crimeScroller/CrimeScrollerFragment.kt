package ru.cursorka.criminal.views.crimeScroller

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.cursorka.criminal.R
import ru.cursorka.criminal.helper.log.ILog

class CrimeScrollerFragment : Fragment(), ILog {
    override val TAG: String
        get() = TODO("not implemented")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_crime_scroller, container, false)
    }


}
