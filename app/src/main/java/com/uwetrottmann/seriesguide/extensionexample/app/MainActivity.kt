package com.uwetrottmann.seriesguide.extensionexample.app

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.battlelancer.seriesguide.api.Intents
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the views by their IDs
        val editText: EditText = findViewById(R.id.editText)
        val saveButton: Button = findViewById(R.id.saveButton)

        // Set a click listener for the Save button
        saveButton.setOnClickListener {
            // Get the text from the EditText
            val text = editText.text.toString()

            // Save the text or show it in a Toast for now
            if (text.isNotEmpty()) {
                // For example, show a Toast as feedback
                Toast.makeText(this, "Saved: $text", Toast.LENGTH_SHORT).show()

                // Here you could save it in SharedPreferences, database, etc.
            } else {
                // Handle empty input
                Toast.makeText(this, "Please enter some text", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
