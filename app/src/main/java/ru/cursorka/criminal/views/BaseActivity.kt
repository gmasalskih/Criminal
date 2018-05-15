package ru.cursorka.criminal.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import org.koin.android.ext.android.releaseContext
import ru.cursorka.criminal.constant.LOG_TAG
import ru.cursorka.criminal.helper.log.ILog
import ru.cursorka.criminal.views.crimeViewer.CrimeViewerPresenter

abstract class BaseActivity : AppCompatActivity(), ILog {

    abstract val context: String
    abstract val fragment: Fragment
    abstract val containerLayout:Int
    abstract val containerId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "$TAG - ${object {}.javaClass.enclosingMethod.name}")
        super.onCreate(savedInstanceState)
        setContentView(containerLayout)
        setFragment()
    }

    private fun setFragment() {
        Log.d(LOG_TAG, "$TAG - ${object {}.javaClass.enclosingMethod.name}")
        if (supportFragmentManager.findFragmentById(containerId) == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(containerId, fragment)
                    .commit()
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "$TAG - ${object {}.javaClass.enclosingMethod.name}")
        releaseContext(context)
    }
}