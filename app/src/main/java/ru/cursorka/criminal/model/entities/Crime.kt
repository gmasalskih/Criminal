package ru.cursorka.criminal.model.entities

import android.util.Log
import ru.cursorka.criminal.constant.LOG_TAG
import ru.cursorka.criminal.helper.log.ILog
import java.util.*

data class Crime(var title: String = "",
                 var isSolved: Boolean = false,
                 var date: Date = Date(),
                 val id: UUID = UUID.randomUUID()
):ILog{
    init {
        Log.d(LOG_TAG, "$TAG - ${this}")
    }
}