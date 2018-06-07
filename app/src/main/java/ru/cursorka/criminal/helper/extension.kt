package ru.cursorka.criminal.helper

import android.support.v4.app.Fragment
import android.util.Log
import java.util.*

/* --- Logging --- */
const val LOG_TAG = "LOG_TAG"

inline fun <reified T : Any> T.log(customTag: String = LOG_TAG, customMsg: String = "") {
    Log.d(customTag, "${javaClass.simpleName} - ${getCalledMethodName()} $customMsg")
}

fun getCalledMethodName(): String = Throwable().stackTrace[1].run { "$methodName()" }

/* --- Retrieve property from intent --- */
fun <T : Any> Fragment.argument(key: String) = lazy {
    activity?.let {
        it.intent.extras[key] as T
    }
}

/* --- Retrieve pretty date format --- */
fun Date.toPretty() = android.text.format.DateFormat.format("dd.MM.yyyy hh:mm", this)