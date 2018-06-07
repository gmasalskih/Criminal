package ru.cursorka.criminal.views.crimeViewer

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import org.jetbrains.anko.support.v4.toast
import org.koin.android.ext.android.inject
import ru.cursorka.criminal.R
import ru.cursorka.criminal.helper.CRIME_ID
import ru.cursorka.criminal.helper.argument
import ru.cursorka.criminal.helper.log
import ru.cursorka.criminal.helper.toPretty
import ru.cursorka.criminal.model.entities.Crime
import java.util.*

class CrimeViewerFragment : Fragment(), ICrimeViewer.View {

    override val presenter by inject<ICrimeViewer.Presenter>()
    private lateinit var crime: Crime
    private lateinit var dateButton: Button
    private lateinit var titleField: EditText
    private lateinit var solvedCheckBox: CheckBox
    private val crimeId by argument<UUID>(CRIME_ID)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log()
        presenter.init(this, crimeId)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        log()
        return inflater.inflate(R.layout.fragment_crime_viewer, container, false).apply {
            dateButton = findViewById(R.id.crime_date)
            titleField = findViewById(R.id.crime_title)
            solvedCheckBox = findViewById(R.id.crime_solved)
        }
    }

    override fun setCrime(crime: Crime) {
        log()
        this.crime = crime
    }

    override fun showErr(msg: String) {
        log()
        toast(msg)
    }

    override fun updateUI() {
        log()
        dateButton.text = crime.date.toPretty()
        dateButton.isEnabled = false
        solvedCheckBox.isChecked = crime.isSolved

        titleField.hint = crime.title

        solvedCheckBox.setOnCheckedChangeListener { _, isChecked ->
            crime.isSolved = isChecked
        }

        titleField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                log()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                log()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                log()
                crime.title = s.toString()
            }
        })

    }

    override fun onPause() {
        super.onPause()
        log()
        presenter.stop()
    }
}