package ru.cursorka.criminal.data.local

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.cursorka.criminal.data.IDAO
import ru.cursorka.criminal.helper.log.Logger
import ru.cursorka.criminal.helper.log.log
import ru.cursorka.criminal.model.entities.Crime
import java.util.*

object LocalDAO : IDAO, Logger {

    override fun saveCrime(crime: Crime) {
        log()
        LocalDB.localDB.add(crime)
    }

    override fun getCrimes(): Observable<Crime> {
        log()
        return Observable.fromIterable(LocalDB.localDB)
                .subscribeOn(Schedulers.io())
    }

    override fun getCrime(id: UUID): Single<Crime> {
        log()
        return Observable.fromIterable(LocalDB.localDB)
                .subscribeOn(Schedulers.io())
                .filter { it.id == id }
                .singleOrError()
    }
}