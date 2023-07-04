package com.example.myfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val textViewRating = findViewById<TextView>(R.id.textViewRating)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.0f)

        textViewResult.text = result.toString()

        val rating = if (result < 18.5f) {
            "Underweight"
        } else if (result in 18.5f..24.9f) {
            "Normal weight"
        } else if (result in 25f..29.9f) {
            "Overweight"
        } else if (result in 30f..39.9f) {
            "Obesity"
        } else {
            "Severe obesity"
        }

        textViewRating.text = getString(R.string.message_rating, rating)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}