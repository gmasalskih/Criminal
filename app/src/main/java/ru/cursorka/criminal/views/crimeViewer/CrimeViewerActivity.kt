package ru.cursorka.criminal.views.crimeViewer

import android.os.Bundle
import android.support.v4.app.Fragment
import org.koin.android.ext.android.inject
import ru.cursorka.criminal.R
import ru.cursorka.criminal.di.CRIME_VIEWER
import ru.cursorka.criminal.views.BaseActivity

class CrimeViewerActivity : BaseActivity() {

    override val context: String = CRIME_VIEWER
    private val fragment: Fragment by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crime_viewer)
        setFragment(5, fragment)
    }
}
