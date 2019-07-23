package com.quevisiter.quevisiter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.quevisiter.quevisiter.common.models.Place
import kotlinx.android.synthetic.main.activity_detail_place.*

class DetailPlaceActivity: AppCompatActivity() {

    private lateinit var place: Place

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_place)

        try {
            place = intent.getParcelableExtra("PLACE") as Place

            activity_detail_place_title.text = place.title
            activity_detail_place_description.text = place.description
            activity_detail_place_categ.text = place.category.name

        }
        catch(e: Exception) {
            Log.d("EEE DetailPlaceActivity", e.toString())
        }



    }
}