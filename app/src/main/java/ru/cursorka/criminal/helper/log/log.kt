package ru.cursorka.criminal.helper.log

import android.util.Log

interface Logger

const val LOG_TAG = "LOG_TAG"

inline fun <reified T : Logger> T.log(customTag: String = LOG_TAG, customMsg: String = "") {
    Log.d(customTag, "${javaClass.simpleName} - ${getCalledMethodName()} $customMsg")
}

fun getCalledMethodName(): String = Throwable().stackTrace[1].run { "$methodName()" }