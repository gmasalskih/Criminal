package ru.cursorka.criminal.views.crimeScroller

import ru.cursorka.criminal.helper.log.ILog
import ru.cursorka.criminal.views.crimeViewer.ICrimeViewer

object CrimeScrollerPresenter:ICrimeScroller.Presenter, ILog {
    override var view: ICrimeScroller.View
        get() = TODO("not implemented")
        set(value) {}

    override fun init(view: ICrimeViewer.View) {
        TODO("not implemented")
    }

    override fun stop() {
        TODO("not implemented")
    }

    override val TAG: String
        get() = TODO("not implemented")
}