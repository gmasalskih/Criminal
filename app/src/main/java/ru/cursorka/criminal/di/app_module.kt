package ru.cursorka.criminal.di

import org.koin.dsl.module.applicationContext
import ru.cursorka.criminal.data.IDAO
import ru.cursorka.criminal.data.local.LocalDAO
import ru.cursorka.criminal.model.EntityProvider
import ru.cursorka.criminal.model.IEntityProvider

val app = applicationContext {
    bean { EntityProvider as IEntityProvider }
    bean { LocalDAO as IDAO }
}