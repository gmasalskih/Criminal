package ru.cursorka.criminal.views.crimeViewer

import android.support.v4.app.Fragment
import org.koin.android.ext.android.inject
import ru.cursorka.criminal.R
import ru.cursorka.criminal.di.CRIME_VIEWER
import ru.cursorka.criminal.views.BaseActivity

class CrimeViewerActivity : BaseActivity() {

    override val context: String = CRIME_VIEWER
    override val fragment by inject<Fragment>(CrimeViewerFragment::class.java.simpleName)
    override val containerId = R.id.activity_crime_viewer_container
    override val containerLayout = R.layout.activity_crime_viewer
}
