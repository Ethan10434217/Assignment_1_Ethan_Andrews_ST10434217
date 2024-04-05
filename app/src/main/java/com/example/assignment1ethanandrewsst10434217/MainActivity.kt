package com.example.assignment1ethanandrewsst10434217

import android.annotation.SuppressLint
import android.icu.util.Output
import android.media.metrics.Event
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    enum class HistoricalEvents (val year: Int, val  description: String) {
        EVENT_1(1989, "Fall of the Berlin wall"),
        EVENT_2(1969, "First moon landing by apollo 11"),
        EVENT_3(1947, "Start of the Cold War"),
        EVENT_4(1984, "The internet was created"),
        EVENT_5(2000, "First year of the new millennium"),
        EVENT_6(2001, "World Trade Center terror attacks"),
        EVENT_7(2010, "Football World Cup is hosted in South Africa"),
        EVENT_8(2019, "Covid pandemic spread around the world"),
        EVENT_9(1999, "Last year of the 1990s"),
        EVENT_10(1955, "Start of the Vietnam War"),

        //creating a list of events to be displayed when entering the users date of birth
    }

        @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // getting components using their ID

            val clearButton = findViewById<Button>(R.id.btnClear)
            val generateButton = findViewById<Button>(R.id.btnGenerateData)
            val editAgeText = findViewById<EditText>(R.id.edtUserAge)
            val outputText = findViewById<TextView>(R.id.txtData)

            clearButton.setOnClickListener{

                editAgeText.text.clear()
                outputText.text = ""
            }

            //code to clear the display and input text

            generateButton?.setOnClickListener()
            {
                val age: Int = editAgeText.text.toString().toInt()

                if (age in 1800..2100) {

                    //the range the age input has to fall in

                val eventYears = HistoricalEvents.entries.map { it.year }

                val events = when (age) {
                    in eventYears -> {
                        val event = HistoricalEvents.entries.find { it.year == age }
                        listOf("In $age: ${event?.description ?: "event"}")
                    }

                    in eventYears.map { it - 1 } -> {
                        val event = HistoricalEvents.values().find { it.year == age + 1 }
                        listOf(
                            "Your Birth Year is one year before the historical event of " + (event?.description ?: "event")
                        )  //displayed the event that was found from the users input
                    }

                    else -> listOf("No historical events found for your age")
                }
                outputText.text = events.joinToString()
            }
                else {
                    outputText.text = "No event has been found from your input"

                    //displaying a prompt showing no events were found from the user input

                }
         }

    }
}