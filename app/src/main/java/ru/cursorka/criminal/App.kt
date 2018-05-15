package ru.cursorka.criminal

import android.app.Application
import android.util.Log
import org.koin.android.ext.android.startKoin
import ru.cursorka.criminal.constant.LOG_TAG
import ru.cursorka.criminal.di.modules
import ru.cursorka.criminal.helper.log.ILog
import ru.cursorka.criminal.views.crimeViewer.CrimeViewerPresenter

class App : Application(), ILog {
    override fun onCreate() {
        super.onCreate()
        Log.d(LOG_TAG, "$TAG - ${object {}.javaClass.enclosingMethod.name}")
        startKoin(this, modules)
    }
}