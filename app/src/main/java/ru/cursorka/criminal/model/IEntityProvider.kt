package ru.cursorka.criminal.model

import io.reactivex.Observable
import io.reactivex.Single
import org.koin.standalone.KoinComponent
import ru.cursorka.criminal.model.entities.Crime
import java.util.*

interface IEntityProvider : KoinComponent {
    fun getListCrimes(): Observable<List<Crime>>
    fun getCrime(id: UUID): Single<Crime>
}