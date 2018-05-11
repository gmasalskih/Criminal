package ru.cursorka.criminal.data.db

import ru.cursorka.criminal.model.entities.Crime

object LocalDB {

    val localDB: List<Crime>

    init {
        localDB = (1..100).toList()
                .map {
                    var crime = Crime("Crime # $it")
                    crime.isSolved = (it % 2 == 0)
                    return@map crime
                }.toList()
    }
}