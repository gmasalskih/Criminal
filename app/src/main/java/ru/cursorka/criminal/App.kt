package ru.cursorka.criminal

import android.app.Application
import org.koin.android.ext.android.startKoin
import ru.cursorka.criminal.di.modules
import ru.cursorka.criminal.helper.log.Logger
import ru.cursorka.criminal.helper.log.log

class App : Application(), Logger {
    override fun onCreate() {
        super.onCreate()
        log()
        startKoin(this, modules)
    }
}