package ru.cursorka.criminal.data.local

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.cursorka.criminal.constant.LOG_TAG
import ru.cursorka.criminal.data.IDAO
import ru.cursorka.criminal.helper.log.ILog
import ru.cursorka.criminal.model.entities.Crime
import java.util.*

object LocalDAO : IDAO, ILog {

    override val TAG = this::class.java.simpleName

    override fun saveCrime(crime: Crime) {
        Log.d(LOG_TAG, "$TAG - ${object{}.javaClass.enclosingMethod.name}")
        LocalDB.localDB.add(crime)
    }

    override fun getCrimes(): Observable<Crime> {
        Log.d(LOG_TAG, "$TAG - ${object{}.javaClass.enclosingMethod.name}")
        return Observable.fromIterable(LocalDB.localDB)
                .subscribeOn(Schedulers.io())
    }

    override fun getCrime(id: UUID): Single<Crime> {
        Log.d(LOG_TAG, "$TAG - ${object{}.javaClass.enclosingMethod.name}")
        return Observable.fromIterable(LocalDB.localDB)
                .subscribeOn(Schedulers.io())
                .filter { it.id == id }
                .singleOrError()
    }
}