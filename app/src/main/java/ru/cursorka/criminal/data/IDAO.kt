package ru.cursorka.criminal.data

import io.reactivex.Observable
import ru.cursorka.criminal.model.entities.Crime

interface IDAO {
    fun getCrimes(): Observable<Crime>
}