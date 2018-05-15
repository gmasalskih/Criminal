package ru.cursorka.criminal.views.crimeScroller

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.ext.android.inject
import ru.cursorka.criminal.R
import ru.cursorka.criminal.constant.LOG_TAG
import ru.cursorka.criminal.helper.log.ILog

class CrimeScrollerFragment : Fragment(), ICrimeScroller.View, ILog {

    override val presenter: ICrimeScroller.Presenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(LOG_TAG, "$TAG - ${object{}.javaClass.enclosingMethod.name}")
        return inflater.inflate(R.layout.fragment_crime_scroller, container, false)
    }

    override fun updateUI() {
        Log.d(LOG_TAG, "$TAG - ${object{}.javaClass.enclosingMethod.name}")

    }


}
