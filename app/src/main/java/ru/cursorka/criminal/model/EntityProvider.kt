package ru.cursorka.criminal.model

import io.reactivex.Single
import org.koin.standalone.inject
import ru.cursorka.criminal.data.IDAO
import ru.cursorka.criminal.helper.log.Logger
import ru.cursorka.criminal.helper.log.log
import ru.cursorka.criminal.model.entities.Crime
import java.util.*

object EntityProvider : IEntityProvider, Logger {

    private val dao by inject<IDAO>()

    override fun getListCrimes(): Single<List<Crime>> {
        log()
        return dao.getCrimes().toList()
    }

    override fun getCrime(id: UUID): Single<Crime> {
        log()
        return dao.getCrime(id)
    }

    override fun getCrime(index: Int): Single<Crime> {
        log()
        return dao.getCrimes().elementAtOrError(index.toLong())
    }
}