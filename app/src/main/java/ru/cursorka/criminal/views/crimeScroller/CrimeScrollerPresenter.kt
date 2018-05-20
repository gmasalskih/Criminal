package ru.cursorka.criminal.views.crimeScroller

import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.standalone.inject
import ru.cursorka.criminal.helper.log.Logger
import ru.cursorka.criminal.helper.log.log
import ru.cursorka.criminal.model.IEntityProvider

object CrimeScrollerPresenter : ICrimeScroller.Presenter, Logger {

    override lateinit var view: ICrimeScroller.View
    private val entityProvider by inject<IEntityProvider>()

    override fun init(view: ICrimeScroller.View) {
        log()
        entityProvider.getListCrimes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.setCrimes(it)
                    view.updateUI()
                },{
                    view.showErr(it.message ?: "CrimeScrollerPresenter.init() - unknown error")
                })
    }

    override fun stop() {
        log()
    }
}