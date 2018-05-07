package ru.cursorka.criminal.data.db

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ru.cursorka.criminal.data.IDAO
import ru.cursorka.criminal.model.entities.Crime

object LocalDAO : IDAO {
    override fun getCrimes(): Observable<Crime> {
        return Observable.fromIterable(localDB)
                .subscribeOn(Schedulers.io())
                .map {
                    Crime(it.toString())
                }
    }
}