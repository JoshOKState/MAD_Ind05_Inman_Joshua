package com.example.mad_ind05_inman_joshua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mad_ind05_inman_joshua.databinding.ActivityStateDetailsBinding

class StateDetails : AppCompatActivity() {
    var binding: ActivityStateDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStateDetailsBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // Display a "back" button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras

        // Check to make sure extras are passed through directly
        if (extras == null) {
            // Error messages to display any errors
            binding?.tvStateNameLabel?.text = "Error - Name Unavailable"
            binding?.tvStateSizeLabel?.text = "Error - Unknown Sq Ft"
        } else {
            // Get the state name and size from values passed through the Intent
            val stateName = extras.getString("name").orEmpty()
            val stateSize = extras.getString("size").orEmpty()
            // Get the image resource id's for the map and flag image names passed
            // through the Intent
            val stateFlagImageResourceId: Int = resources.getIdentifier(extras.getString("flagImageName").orEmpty(), "drawable", packageName)
            val stateMapImageResourceId: Int = resources.getIdentifier(extras.getString("mapImageName").orEmpty(), "drawable", packageName)

            // Replace the components in the activity with the values passed
            // through the Intent.
            binding?.tvStateNameLabel?.text = stateName
            binding?.tvStateSizeLabel?.text = "$stateSize Sq Ft"
            binding?.ivStateFlagImage?.setImageResource(stateFlagImageResourceId)
            binding?.ivStateMapImage?.setImageResource(stateMapImageResourceId)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        // Call "finished" to initiate a return to the source.
        finish()

        return super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }
}