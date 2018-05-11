package ru.cursorka.criminal.di

import org.koin.dsl.module.applicationContext

const val CRIME_VIEWER = "CRIME_VIEWER"

val crimeViewer = applicationContext {
    context(CRIME_VIEWER){

    }
}