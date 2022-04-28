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

        if (extras == null) {
            binding?.tvStateNameLabel?.text = "Error - Name Unavailable"
            binding?.tvStateSizeLabel?.text = "Error - Unknown Sq Ft"
        } else {
            val stateName = extras.getString("name").orEmpty()
            val stateSize = extras.getString("size").orEmpty()
            val stateFlagImageResourceId: Int = resources.getIdentifier(extras.getString("flagImageName").orEmpty(), "drawable", packageName)
            val stateMapImageResourceId: Int = resources.getIdentifier(extras.getString("mapImageName").orEmpty(), "drawable", packageName)

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