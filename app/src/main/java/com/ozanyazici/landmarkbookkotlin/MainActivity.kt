package com.ozanyazici.landmarkbookkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozanyazici.landmarkbookkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var landmarkList : ArrayList<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        landmarkList = ArrayList<Landmark>()

        //Data

        val pisa = Landmark("Pisa", "Italy", R.drawable.pisa)
        val eiffel = Landmark("Eiffel", "France", R.drawable.eiffel)
        val colosseum = Landmark("Colosseum", "Italy", R.drawable.colosseum)
        val londonBridge = Landmark("London Bridge", "UK", R.drawable.london)

        landmarkList.add(pisa)
        landmarkList.add(eiffel)
        landmarkList.add(colosseum)
        landmarkList.add(londonBridge)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val landMarkAdapter = LandMarkAdapter(landmarkList)
        binding.recyclerView.adapter = landMarkAdapter
    }
}