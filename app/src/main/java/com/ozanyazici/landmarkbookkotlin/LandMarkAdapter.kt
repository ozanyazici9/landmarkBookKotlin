package com.ozanyazici.landmarkbookkotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.ozanyazici.landmarkbookkotlin.databinding.RecyclerRowBinding

class LandMarkAdapter(val landmarkList : ArrayList<Landmark>) : RecyclerView.Adapter<LandMarkAdapter.LandMarkHolder>() {



    class LandMarkHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandMarkHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LandMarkHolder(binding)

    }

    override fun getItemCount(): Int {
        return landmarkList.size

    }

    override fun onBindViewHolder(holder: LandMarkHolder, position: Int) {
        holder.binding.recyclerViewTextView.text = landmarkList.get(position).name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            //intent.putExtra("landmark",landmarkList.get(position))
            MySingleton.chosenLandmark = landmarkList.get(position)
            holder.itemView.context.startActivity(intent)
        }

    }
}