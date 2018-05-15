package ru.cursorka.criminal.di

import android.support.v4.app.Fragment
import org.koin.dsl.module.applicationContext
import ru.cursorka.criminal.views.crimeScroller.CrimeScrollerFragment
import ru.cursorka.criminal.views.crimeScroller.CrimeScrollerPresenter
import ru.cursorka.criminal.views.crimeScroller.ICrimeScroller

const val CRIME_SCROLLER = "CRIME_SCROLLER"

val crimeScroller = applicationContext {
    context(CRIME_SCROLLER){
        factory (CrimeScrollerFragment::class.java.simpleName) { CrimeScrollerFragment() as Fragment }
        bean { CrimeScrollerPresenter as ICrimeScroller.Presenter }
    }
}