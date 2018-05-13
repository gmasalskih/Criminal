package ru.cursorka.criminal.model

import android.util.Log
import io.reactivex.Single
import org.koin.standalone.inject
import ru.cursorka.criminal.constant.LOG_TAG
import ru.cursorka.criminal.data.IDAO
import ru.cursorka.criminal.helper.log.ILog
import ru.cursorka.criminal.model.entities.Crime
import java.util.*

object EntityProvider : IEntityProvider, ILog {

    override val TAG = this::class.java.simpleName

    private val dao by inject<IDAO>()

    override fun getListCrimes(): Single<List<Crime>> {
        Log.d(LOG_TAG, "$TAG - ${object{}.javaClass.enclosingMethod.name}")
        return dao.getCrimes().toList()
    }

    override fun getCrime(id: UUID): Single<Crime> {
        Log.d(LOG_TAG, "$TAG - ${object{}.javaClass.enclosingMethod.name}")
        return dao.getCrime(id)
    }

    override fun getCrime(index: Int): Single<Crime> {
        Log.d(LOG_TAG, "$TAG - ${object{}.javaClass.enclosingMethod.name}")
        return dao.getCrimes().elementAtOrError(index.toLong())
    }
}