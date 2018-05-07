package ru.cursorka.criminal.model

import io.reactivex.Observable
import org.koin.standalone.inject
import ru.cursorka.criminal.data.IDAO
import ru.cursorka.criminal.model.entities.Crime

object EntityProvider : IEntityProvider {

    private val dao: IDAO by inject()

    override fun getListCrimes(): Observable<List<Crime>> {
        return dao.getCrimes()
                .toList()
                .toObservable()
    }

}