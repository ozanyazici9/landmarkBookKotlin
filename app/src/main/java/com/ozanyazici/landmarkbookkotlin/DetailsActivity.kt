package com.ozanyazici.landmarkbookkotlin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozanyazici.landmarkbookkotlin.databinding.ActivityDetailsBinding
import com.ozanyazici.landmarkbookkotlin.databinding.ActivityMainBinding
import java.io.Serializable

class DetailsActivity : AppCompatActivity() {

    private val selectedLandmark = MySingleton.chosenLandmark

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent

        /* veriyi intent ile göndermek büyük boyutlarda verimli değil. bu durumlarada Singleton kullanmak daha verimli
        intent ile yapılacaksa version kontrolü ile yapılmalı

         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
             selectedLandmark = intent.getSerializableExtra("landmark", Landmark::class.java) as Landmark
             binding.countryText.text = selectedLandmark.country
             binding.imageView.setImageResource(selectedLandmark.image)
             binding.nameText.text = selectedLandmark.name

         } else {
             selectedLandmark = intent.getSerializableExtra("landmark") as Landmark
             binding.countryText.text = selectedLandmark.country
             binding.imageView.setImageResource(selectedLandmark.image)
             binding.nameText.text = selectedLandmark.name
        }
        */

        selectedLandmark?.let {
            binding.countryText.text = it.country
            binding.imageView.setImageResource(it.image)
            binding.nameText.text = it.name
        }
    }
}