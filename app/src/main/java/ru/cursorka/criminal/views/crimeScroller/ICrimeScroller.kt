package ru.cursorka.criminal.views.crimeScroller

import org.koin.standalone.KoinComponent
import ru.cursorka.criminal.model.entities.Crime
import ru.cursorka.criminal.views.crimeViewer.ICrimeViewer

interface ICrimeScroller {
    interface View {
        val presenter: ICrimeScroller.Presenter
        fun setCrimes(crimes: List<Crime>)
        fun updateUI()
        fun showErr(msg: String)
    }

    interface Presenter : KoinComponent {
        var view: ICrimeScroller.View
        fun init(view: ICrimeScroller.View)
        fun stop()
    }
}