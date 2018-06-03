package ru.cursorka.criminal.model

import io.reactivex.Observable
import io.reactivex.Single
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import ru.cursorka.criminal.data.IDAO
import ru.cursorka.criminal.helper.log.Logger
import ru.cursorka.criminal.helper.log.log
import ru.cursorka.criminal.model.entities.Crime
import java.util.*
import kotlin.collections.ArrayList

object EntityProvider : KoinComponent, Logger {

    private val dao by inject<IDAO>()
    private var crimes: List<Crime> = ArrayList<Crime>().toList()

    init {
        log()
        dao.getCrimes().subscribe { crimes = it }
    }

    fun getListCrimes(): Observable<List<Crime>> {
        log()
        return if (crimes.isEmpty()){
            dao.getCrimes()
        } else{
            Observable.just(crimes)
        }
    }

    fun getCrime(id: UUID): Single<Crime> {
        log()
        return getListCrimes().flatMap {
            Observable.fromIterable(it)
        }.filter {
            it.id == id
        }.singleOrError()
    }
}