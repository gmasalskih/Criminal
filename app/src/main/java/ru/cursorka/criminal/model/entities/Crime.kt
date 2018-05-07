package ru.cursorka.criminal.model.entities

import java.util.*

data class Crime(var title: String, val date: Date = Date(), val id: UUID = UUID.randomUUID())