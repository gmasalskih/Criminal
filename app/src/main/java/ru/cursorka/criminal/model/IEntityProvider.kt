package ru.cursorka.criminal.model

import io.reactivex.Observable
import org.koin.standalone.KoinComponent
import ru.cursorka.criminal.model.entities.Crime

interface IEntityProvider : KoinComponent {
    fun getListCrimes(): Observable<List<Crime>>
}