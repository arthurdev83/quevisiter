package com.quevisiter.quevisiter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: MainRecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val retrofitService: RetrofitService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myDataset: Array<String> = arrayOf("Lithuanie", "Guatemala", "Japon", "France", "Guadeloupe", "Danemark")


        /*viewManager = RecyclerView(this)
        viewAdapter = MainRecyclerView(myDataset)

        recyclerView = findViewById<RecyclerView>(R.id.activity_main_recyclerview).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }*/

        activity_main_go_to_login.setOnClickListener {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        //activity_main_recyclerview

        val placeService = retrofitService.retrofit.create(PlaceRepository::class.java)
        val placeRequest = placeService.getPlaces()

        placeRequest.enqueue(object : Callback<List<SearchedPlace>> {
            override fun onResponse(call: Call<List<SearchedPlace>>, response: Response<List<SearchedPlace>>) {

                val toto = response.body()

                if (toto != null) {
                    Log.d("response", "my response")

                    rep_api.text = toto.toString()
                    // show snackbar
                    //utils.showSnackbar(containerProfil, R.string.localized_lang_dialog_report_account_report_notification)
                }else {
                    Log.d("errorResponse", "my response ERRORRED")
                }

            }

            override fun onFailure(call: Call<List<SearchedPlace>>, t: Throwable) {
                Log.d("error", t.toString())

            }
        })
        //montext.text = toto[0].name
    }
}
