package ru.cursorka.criminal.views.crimeViewer

import org.koin.standalone.KoinComponent
import ru.cursorka.criminal.model.entities.Crime
import java.util.*


interface ICrimeViewer {
    interface View {
        val presenter: ICrimeViewer.Presenter
        fun setCrime(crime: Crime)
        fun showErr(msg: String)
        fun updateUI()
    }

    interface Presenter : KoinComponent {
        var view: ICrimeViewer.View
        fun init(view: ICrimeViewer.View)
        fun stop()
    }
}