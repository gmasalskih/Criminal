package ru.cursorka.criminal.helper.log

import android.util.Log
import ru.cursorka.criminal.constant.LOG_TAG

interface Logger

inline fun <reified T : Logger> T.log() {
    Log.d(LOG_TAG, "${javaClass.simpleName} - ${getCalledMethodName()}")
}

fun getCalledMethodName(): String = Throwable().stackTrace[1].run { "$methodName()" }