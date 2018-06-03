package ru.cursorka.criminal.data.local

import ru.cursorka.criminal.helper.log.Logger
import ru.cursorka.criminal.helper.log.log
import ru.cursorka.criminal.model.entities.Crime

object LocalDB:Logger {

    val localDB: MutableList<Crime>

    init {
        log()
        localDB = (1..100).toList()
                .map {
                    Crime("Crime # $it").apply { isSolved = it%2==0 }
                }.toMutableList()
    }
}