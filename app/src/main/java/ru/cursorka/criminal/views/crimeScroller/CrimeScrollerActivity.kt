package ru.cursorka.criminal.views.crimeScroller

import android.support.v4.app.Fragment
import org.koin.android.ext.android.inject
import ru.cursorka.criminal.R
import ru.cursorka.criminal.di.CRIME_SCROLLER
import ru.cursorka.criminal.views.BaseActivity

class CrimeScrollerActivity : BaseActivity() {
    override val context = CRIME_SCROLLER
    override val fragment by inject<Fragment>(CrimeScrollerFragment::class.java.simpleName)
    override val containerLayout: Int = R.layout.activity_crime_scroller
    override val containerId: Int = R.id.activity_crime_scroller_container
}
