package ru.cursorka.criminal.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import org.koin.android.ext.android.releaseContext
import ru.cursorka.criminal.helper.ext.*

abstract class BaseActivity : AppCompatActivity() {

    abstract val context: String
    abstract val fragment: Fragment
    abstract val containerLayout:Int
    abstract val containerId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        log()
        super.onCreate(savedInstanceState)
        setContentView(containerLayout)
        setFragment()
    }

    private fun setFragment() {
        log()
        if (supportFragmentManager.findFragmentById(containerId) == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(containerId, fragment)
                    .commit()
        }
    }

    override fun onPause() {
        super.onPause()
        log()
        releaseContext(context)
    }
}