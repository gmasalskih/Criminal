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
import ru.cursorka.criminal.model.entities.Crime

class CrimeViewerFragment : Fragment(), ICrimeViewer.View {

    override val presenter by inject<ICrimeViewer.Presenter>()
    private lateinit var crime: Crime
    private lateinit var dateButton: Button
    private lateinit var titleField: EditText
    private lateinit var solvedCheckBox: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.init(this)
        Log.d("AAA", "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_crime_viewer, container, false)
        dateButton = view.findViewById(R.id.crime_date)
        titleField = view.findViewById(R.id.crime_title)
        solvedCheckBox = view.findViewById(R.id.crime_solved)
        return view
    }

    override fun setCrime(crime: Crime) {
        this.crime = crime
    }

    override fun showErr(msg: String) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
    }

    override fun updateUI() {
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

    override fun onStop() {
        super.onStop()
        presenter.stop()
    }
}