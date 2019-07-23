package com.quevisiter.quevisiter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.quevisiter.quevisiter.common.models.Place
import com.quevisiter.quevisiter.common.models.SearchedPlace
import com.quevisiter.quevisiter.common.network.RetrofitService
import kotlinx.android.synthetic.main.activity_see_all.*
import org.koin.android.ext.android.inject
import picshare.guillaume.picshare.Adapters.SeeAllAdapter
import java.lang.Exception

class SeeAllActivity: AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val retrofitService: RetrofitService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_all)

        try {
            val b = intent.extras
            val places = b!!.getParcelableArrayList<SearchedPlace>("LIST_PLACES")

            viewManager = LinearLayoutManager(this@SeeAllActivity)
            viewAdapter = SeeAllAdapter(places) { it : Place, _: Int ->
                val intent = Intent(this@SeeAllActivity, DetailPlaceActivity::class.java)
                intent.putExtra("PLACE", it)
                startActivity(intent)
            }

            recyclerView = activity_see_all_recyclerview.apply {

                setHasFixedSize(true)
                layoutManager = viewManager
                adapter = viewAdapter

            }



        }
        catch(e: Exception) {
            Log.d("EEEEEEE SeeAllActivity", e.toString())
        }

    }



}