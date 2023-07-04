package com.example.myfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val edtWeight: EditText = findViewById(R.id.edtWeight)
        val edtHeight: EditText = findViewById(R.id.edtHeight)

        btnCalculate.setOnClickListener() {

            val strHeight = edtHeight.text.toString()
            val strWeight = edtWeight.text.toString()

            if (strHeight.isNotEmpty() && strWeight.isNotEmpty()) {
                val height: Float = strHeight.toFloat()
                val weight: Float = strWeight.toFloat()

                val finalHeight: Float = height * height
                val result: Float = weight / finalHeight

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Fill in all fields to continue", Toast.LENGTH_LONG).show()
            }
        }
    }
}