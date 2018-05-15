package ru.cursorka.criminal.views.crimeScroller

import android.util.Log
import ru.cursorka.criminal.constant.LOG_TAG
import ru.cursorka.criminal.helper.log.ILog
import ru.cursorka.criminal.views.crimeViewer.ICrimeViewer

object CrimeScrollerPresenter : ICrimeScroller.Presenter, ILog {

    override lateinit var view: ICrimeScroller.View

    override fun init(view: ICrimeViewer.View) {
        Log.d(LOG_TAG, "$TAG - ${object {}.javaClass.enclosingMethod.name}")

    }

    override fun stop() {
        Log.d(LOG_TAG, "$TAG - ${object {}.javaClass.enclosingMethod.name}")
    }
}