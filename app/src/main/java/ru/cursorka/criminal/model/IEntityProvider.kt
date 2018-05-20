package ru.cursorka.criminal.model

import io.reactivex.Single
import org.koin.standalone.KoinComponent
import ru.cursorka.criminal.model.entities.Crime
import java.util.*

interface IEntityProvider : KoinComponent {

    fun getListCrimes(): Single<List<Crime>>
    fun getCrime(id: UUID): Single<Crime>
    fun getCrime(index: Int): Single<Crime>
}