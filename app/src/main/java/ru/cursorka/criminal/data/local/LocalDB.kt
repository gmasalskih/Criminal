package ru.cursorka.criminal.data.local

import ru.cursorka.criminal.model.entities.Crime

object LocalDB {

    val localDB: MutableList<Crime>

    init {
        localDB = (1..100).toList()
                .map {
                    var crime = Crime("Crime # $it")
                    crime.isSolved = (it % 2 == 0)
                    return@map crime
                }.toMutableList()
    }
}