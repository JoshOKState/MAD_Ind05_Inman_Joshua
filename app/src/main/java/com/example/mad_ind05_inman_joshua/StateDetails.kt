package com.example.mad_ind05_inman_joshua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class StateDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_details)

        // Display a "back" button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        // Call "finished" to initiate a return to the source.
        finish()

        return super.onSupportNavigateUp()
    }
}