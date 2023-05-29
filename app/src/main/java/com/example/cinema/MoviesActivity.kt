package com.example.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.system.exitProcess

class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = GridLayoutManager(this,2)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(ItemsViewModel(com.firebase.ui.auth.R.drawable.common_full_open_on_phone, "Item " + i))
        }


        val apiInterface = ApiInterface.create().getMovies("most_pop_movies")

        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue( object : Callback<movies>, CustomAdapter.ItemClickListener {
            override fun onResponse(call: Call<movies>?, response: Response<movies>?) {

                Log.d("testLogs", "Onresponce sucsess ${response?.body()?.results}")
                // This will pass the ArrayList to our Adapter
                val adapter = CustomAdapter(response?.body()?.results,this)

                // Setting the Adapter with the recyclerview
                recyclerview.adapter = adapter



            }

            override fun onFailure(call: Call<movies>?, t: Throwable?) {
                Log.d("testLogs", "OnFailure: ${t?.message}")
            }

            override fun onItemClick(position: Int) {
                Log.d("Click","Clicked position $position")
            }
        })

            @Deprecated("Deprecated in Java")
            fun onBackPressed() {
                finishAffinity()
                exitProcess(0)
            }
    }


}

