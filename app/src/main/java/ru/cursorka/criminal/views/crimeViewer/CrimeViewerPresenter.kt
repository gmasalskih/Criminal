package ru.cursorka.criminal.views.crimeViewer

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import org.koin.standalone.inject
import ru.cursorka.criminal.constant.LOG_TAG
import ru.cursorka.criminal.helper.log.ILog
import ru.cursorka.criminal.model.IEntityProvider

object CrimeViewerPresenter : ICrimeViewer.Presenter, ILog {

    override val TAG = this::class.java.simpleName
    override lateinit var view: ICrimeViewer.View

    private val entityProvider by inject<IEntityProvider>()
    private val compositeDisposable = CompositeDisposable()

    override fun init(view: ICrimeViewer.View) {
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
        Log.d(LOG_TAG, "$TAG - ${object {}.javaClass.enclosingMethod.name}")
    }

    override fun stop() {
        compositeDisposable.clear()
        Log.d(LOG_TAG, "$TAG - ${object {}.javaClass.enclosingMethod.name}")
    }
}