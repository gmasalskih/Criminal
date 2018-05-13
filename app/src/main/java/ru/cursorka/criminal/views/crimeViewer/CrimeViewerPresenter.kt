package ru.cursorka.criminal.views.crimeViewer

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import org.koin.standalone.inject
import ru.cursorka.criminal.model.IEntityProvider

object CrimeViewerPresenter : ICrimeViewer.Presenter {

    override lateinit var view: ICrimeViewer.View

    private val entityProvider by inject<IEntityProvider>()
    private val compositeDisposable = CompositeDisposable()

    override fun init(view: ICrimeViewer.View) {
        Log.d("BBB", "Presenter init")
        this.view = view
        val subscription = entityProvider.getListCrimes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("BBB", "Presenter setCrime")
                    view.setCrime(it[0])
                    view.updateUI()
                }, {
                    view.showErr(it.message.toString())
                })
        compositeDisposable.add(subscription)
    }

    override fun stop() {
        compositeDisposable.clear()
    }
}