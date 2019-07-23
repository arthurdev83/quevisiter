package com.quevisiter.quevisiter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.quevisiter.quevisiter.common.models.SearchedPlace
import com.quevisiter.quevisiter.common.network.PlaceRepository
import com.quevisiter.quevisiter.common.network.RetrofitService
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import picshare.guillaume.picshare.Adapters.MainRecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val retrofitService: RetrofitService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myDataset: Array<String> = arrayOf("Lithuanie", "Guatemala", "Japon", "France", "Guadeloupe", "Danemark")




        activity_main_go_to_login.setOnClickListener {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }



        //activity_main_recyclerview

        val placeService = retrofitService.retrofit.create(PlaceRepository::class.java)
        val placeRequest = placeService.getPlaces()

        placeRequest.enqueue(object : Callback<List<SearchedPlace>> {
            override fun onResponse(call: Call<List<SearchedPlace>>, response: Response<List<SearchedPlace>>) {

                val allplaces = response.body()

                if (allplaces != null) {
                    Log.d("response", "my response")

                    viewManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL ,false)
                    viewAdapter = MainRecyclerView(allplaces)

                    recyclerView = activity_main_recyclerview.apply {
                        // use this setting to improve performance if you know that changes
                        // in content do not change the layout size of the RecyclerView
                        setHasFixedSize(true)

                        // use a linear layout manager
                        layoutManager = viewManager

                        // specify an viewAdapter (see also next example)
                        adapter = viewAdapter

                    }

                    activity_main_see_all.setOnClickListener {
                        val intent = Intent(this@MainActivity, SeeAllActivity::class.java)
                        intent.putParcelableArrayListExtra("LIST_PLACES", allplaces as ArrayList<SearchedPlace>)
                        startActivity(intent)
                    }

                }else {
                    Log.d("errorResponse", "my response ERRORRED")
                }

            }

            override fun onFailure(call: Call<List<SearchedPlace>>, t: Throwable) {
                Log.d("EEEEEEE MainActivity", t.toString())

            }
        })
    }
}
