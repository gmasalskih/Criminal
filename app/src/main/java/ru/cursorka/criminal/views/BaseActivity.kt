package ru.cursorka.criminal.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import org.koin.android.ext.android.releaseContext

abstract class BaseActivity : AppCompatActivity() {

    abstract val context: String
    abstract val fragment: Fragment
    abstract val containerLayout:Int
    abstract val containerId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(containerLayout)
        setFragment()
    }

    private fun setFragment() {
        if (supportFragmentManager.findFragmentById(containerId) == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(containerId, fragment)
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