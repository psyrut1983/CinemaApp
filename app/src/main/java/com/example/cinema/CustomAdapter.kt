package com.example.cinema

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import retrofit2.http.Url

class CustomAdapter(private val mList: List<Result>?,
val mItemClickListener:ItemClickListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    interface ItemClickListener{
        fun onItemClick(position: Int)
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList?.get(position)

        // sets the image to the imageview from our itemHolder class
        Picasso.get().load("${mList?.get(position)?.primaryImage?.url})").into(holder.imageView);
Log.d("imageURL", "${mList?.get(position)?.primaryImage?.url}")



    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList?.size!!
    }

    // Holds the views for adding it to image and text
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        init {
            ItemView.setOnClickListener { mItemClickListener.onItemClick(adapterPosition) }
        }

    }
}