package ru.cursorka.criminal.di

import org.koin.dsl.module.applicationContext

const val CRIME_SCROLLER = "CRIME_SCROLLER"

val crimeScroller = applicationContext {
    context(CRIME_SCROLLER){

    }
}