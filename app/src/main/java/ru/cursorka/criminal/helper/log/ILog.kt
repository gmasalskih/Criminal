package ru.cursorka.criminal.helper.log


interface ILog {
    val TAG: String
        get() = javaClass.simpleName
}