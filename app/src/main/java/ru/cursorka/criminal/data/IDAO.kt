package ru.cursorka.criminal.data

import io.reactivex.Observable
import io.reactivex.Single
import ru.cursorka.criminal.model.entities.Crime
import java.util.*

interface IDAO {
    fun getCrimes(): Observable<Crime>
    fun getCrime(id: UUID): Single<Crime>
    fun saveCrime(crime: Crime)

}