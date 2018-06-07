package ru.cursorka.criminal.views.crimeViewer

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import org.koin.standalone.inject
import ru.cursorka.criminal.helper.log
import ru.cursorka.criminal.model.EntityProvider
import ru.cursorka.criminal.model.entities.Crime
import java.util.*

object CrimeViewerPresenter : ICrimeViewer.Presenter {

    override lateinit var view: ICrimeViewer.View

    private val entityProvider by inject<EntityProvider>()
    private val compositeDisposable = CompositeDisposable()

    override fun init(view: ICrimeViewer.View, crimeId: UUID?) {
        log()
        this.view = view
        if (crimeId != null) {
            val subscription = entityProvider.getCrime(crimeId)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        view.setCrime(it)
                        view.updateUI()
                    }, {
                        view.showErr(it.message.toString())
                    })
            compositeDisposable.add(subscription)
        } else {
            view.showErr("Crime not found")
        }

    }

    override fun stop() {
        log()
        compositeDisposable.clear()
    }
}