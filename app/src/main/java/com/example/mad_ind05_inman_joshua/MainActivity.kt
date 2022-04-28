package com.example.mad_ind05_inman_joshua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mad_ind05_inman_joshua.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val adapter = MyAdapter(StateDataModel.stateList, this)
        binding?.rvStateDetails?.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }
}