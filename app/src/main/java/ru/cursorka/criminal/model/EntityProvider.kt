package ru.cursorka.criminal.model

import io.reactivex.Observable
import io.reactivex.Single
import org.koin.standalone.inject
import ru.cursorka.criminal.data.IDAO
import ru.cursorka.criminal.model.entities.Crime
import java.util.*

object EntityProvider : IEntityProvider {

    private val dao: IDAO by inject()

    override fun getListCrimes(): Observable<List<Crime>> {
        return dao.getCrimes()
    }

    override fun getCrime(id: UUID): Single<Crime> {
        return dao.getCrime(id)
    }



}