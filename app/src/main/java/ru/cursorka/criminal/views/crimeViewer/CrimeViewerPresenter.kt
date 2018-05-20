package ru.cursorka.criminal.views.crimeViewer

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import org.koin.standalone.inject
import ru.cursorka.criminal.helper.log.Logger
import ru.cursorka.criminal.helper.log.log
import ru.cursorka.criminal.model.IEntityProvider

object CrimeViewerPresenter : ICrimeViewer.Presenter, Logger {

    override lateinit var view: ICrimeViewer.View

    private val entityProvider by inject<IEntityProvider>()
    private val compositeDisposable = CompositeDisposable()

    override fun init(view: ICrimeViewer.View) {
        log()
        this.view = view
        val subscription = entityProvider.getListCrimes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.setCrime(it[0])
                    view.updateUI()
                }, {
                    view.showErr(it.message.toString())
                })
        compositeDisposable.add(subscription)
    }

    override fun stop() {
        log()
        compositeDisposable.clear()
    }
}