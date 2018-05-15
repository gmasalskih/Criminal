package ru.cursorka.criminal.views.crimeViewer

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import org.koin.android.ext.android.inject
import ru.cursorka.criminal.R
import ru.cursorka.criminal.constant.LOG_TAG
import ru.cursorka.criminal.helper.log.ILog
import ru.cursorka.criminal.model.entities.Crime

class CrimeViewerFragment : Fragment(), ICrimeViewer.View, ILog {

    override val presenter by inject<ICrimeViewer.Presenter>()
    private lateinit var crime: Crime
    private lateinit var dateButton: Button
    private lateinit var titleField: EditText
    private lateinit var solvedCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "$TAG - ${object{}.javaClass.enclosingMethod.name}")
        presenter.init(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(LOG_TAG, "$TAG - ${object{}.javaClass.enclosingMethod.name}")
        return inflater.inflate(R.layout.fragment_crime_viewer, container, false).apply {
            dateButton = findViewById(R.id.crime_date)
            titleField = findViewById(R.id.crime_title)
            solvedCheckBox = findViewById(R.id.crime_solved)
        }
    }

    override fun setCrime(crime: Crime) {
        Log.d(LOG_TAG, "$TAG - ${object{}.javaClass.enclosingMethod.name}")
        this.crime = crime
    }

    override fun showErr(msg: String) {
        Log.d(LOG_TAG, "$TAG - ${object{}.javaClass.enclosingMethod.name}")
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
    }

    override fun updateUI() {
        Log.d(LOG_TAG, "$TAG - ${object{}.javaClass.enclosingMethod.name}")
        dateButton.text = crime.date.toString()
        dateButton.isEnabled = false

        solvedCheckBox.setOnCheckedChangeListener { _, isChecked ->
            crime.isSolved = isChecked
        }

        titleField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                crime.title = s.toString()
            }
        })

    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "$TAG - ${object{}.javaClass.enclosingMethod.name}")
        presenter.stop()
    }
}