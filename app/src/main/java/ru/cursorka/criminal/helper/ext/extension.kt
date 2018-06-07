package ru.cursorka.criminal.helper.ext

import android.util.Log

/* --- Logging --- */
const val LOG_TAG = "LOG_TAG"

inline fun <reified T : Any> T.log(customTag: String = LOG_TAG, customMsg: String = "") {
    Log.d(customTag, "${javaClass.simpleName} - ${getCalledMethodName()} $customMsg")
}

fun getCalledMethodName(): String = Throwable().stackTrace[1].run { "$methodName()" }