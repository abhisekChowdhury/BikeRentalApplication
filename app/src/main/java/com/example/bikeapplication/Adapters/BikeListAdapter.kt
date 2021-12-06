package com.example.bikeapplication.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bikeapplication.Entities.BikeEntity
import com.example.bikeapplication.R
import com.example.bikeapplication.databinding.ListItemBinding

class BikeListAdapter(private val bikeList: List<BikeEntity>,
                      private val listener: ListItemListener
): RecyclerView.Adapter<BikeListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val binding = ListItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bike = bikeList[position]
        with(holder.binding) {
            bikeNameTextView.text = bike.BikeType
            vendorNameTextView.text = bike.Brand
            costPerHourTextView.text = bike.Price
            if(bike.Brand.equals("GIANT",ignoreCase = true)){
                bikeListImageView.setImageResource(R.drawable.bike1)
            }
            else if(bike.Brand.equals("LIV",ignoreCase = true)){
                bikeListImageView.setImageResource(R.drawable.bike2)
            }
            else if(bike.Brand.equals("HERO",ignoreCase = true)){
                bikeListImageView.setImageResource(R.drawable.bike3)
            }
            else if(bike.Brand.equals("HERCULES",ignoreCase = true)){
                bikeListImageView.setImageResource(R.drawable.bike4)
            }
            else if(bike.Brand.equals("TREK",ignoreCase = true)){
                bikeListImageView.setImageResource(R.drawable.bike5)
            }
            else{
                bikeListImageView.setImageResource(R.drawable.bello_logos_transparent)
            }
            root.setOnClickListener{
                listener.onItemClick(bike._id.`$oid`)
            }
        }
    }

    override fun getItemCount(): Int {
        return bikeList.size
    }

    interface ListItemListener {
        //fun editNote(noteId: Int)
        fun onItemClick(noteId: String)
    }

}