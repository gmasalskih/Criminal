package ru.cursorka.criminal.di

import android.support.v4.app.Fragment
import org.koin.dsl.module.applicationContext
import ru.cursorka.criminal.model.EntityProvider
import ru.cursorka.criminal.model.IEntityProvider
import ru.cursorka.criminal.views.crimeViewer.CrimeViewerFragment
import ru.cursorka.criminal.views.crimeViewer.CrimeViewerPresenter
import ru.cursorka.criminal.views.crimeViewer.ICrimeViewer

const val CRIME_VIEWER = "CRIME_VIEWER"

val crimeViewer = applicationContext {
    context(CRIME_VIEWER){
        factory (CrimeViewerFragment::class.java.simpleName) { CrimeViewerFragment() as Fragment }
        bean { CrimeViewerPresenter as ICrimeViewer.Presenter }
    }
}