package ru.cursorka.criminal.views.crimeScroller

import org.koin.standalone.KoinComponent
import ru.cursorka.criminal.views.crimeViewer.ICrimeViewer

interface ICrimeScroller {
    interface View {
        val presenter: ICrimeScroller.Presenter
        fun updateUI()
    }

    interface Presenter : KoinComponent {
        var view: ICrimeScroller.View
        fun init(view: ICrimeViewer.View)
        fun stop()
    }
}