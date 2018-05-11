package ru.cursorka.criminal.model.entities

import java.util.*

data class Crime(var title: String = "") {
    var isSolved: Boolean = false
    val date: Date = Date()
    val id: UUID = UUID.randomUUID()
}