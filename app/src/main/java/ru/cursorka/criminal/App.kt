package ru.cursorka.criminal

import android.app.Application
import org.koin.android.ext.android.startKoin
import ru.cursorka.criminal.di.modules

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, modules)
    }
}