package ru.cursorka.criminal.views

import android.annotation.SuppressLint
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import org.koin.android.ext.android.releaseContext

abstract class BaseActivity : AppCompatActivity() {

    abstract val context: String

    fun setFragment(container: Int, fragment: Fragment) {
        if (supportFragmentManager.findFragmentById(container) == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(container, fragment)
                    .commit()
        }
        Log.d("AAA", "setFragment")
    }

    @SuppressLint("MissingSuperCall")
    override fun onPause() {
        super.onPause()
        releaseContext(context)
    }
}