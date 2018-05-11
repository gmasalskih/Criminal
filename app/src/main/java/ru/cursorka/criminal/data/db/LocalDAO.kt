package ru.cursorka.criminal.data.db

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.cursorka.criminal.data.IDAO
import ru.cursorka.criminal.model.entities.Crime
import java.util.*

object LocalDAO : IDAO {

    override fun getCrimes(): Observable<List<Crime>> {
        return Observable.fromIterable(LocalDB.localDB)
                .subscribeOn(Schedulers.io())
                .toList()
                .toObservable()
    }

    override fun getCrime(id: UUID): Single<Crime> {
        return Observable.fromIterable(LocalDB.localDB)
                .subscribeOn(Schedulers.io())
                .filter { it.id == id }
                .singleOrError()
    }
}