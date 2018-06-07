package ru.cursorka.criminal.helper.ext

import android.util.Log
import android.view.View
import android.widget.Toast

/* --- Logging --- */
const val LOG_TAG = "LOG_TAG"

inline fun <reified T : Any> T.log(customTag: String = LOG_TAG, customMsg: String = "") {
    Log.d(customTag, "${javaClass.simpleName} - ${getCalledMethodName()} $customMsg")
}

fun getCalledMethodName(): String = Throwable().stackTrace[1].run { "$methodName()" }

/* --- Toast --- */
fun View.toast(msg: String = "", duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this.context, "$msg", duration).show()
}