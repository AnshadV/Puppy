package com.anshad.puppyList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.anshad.puppy.R
import com.anshad.data.Puppy
import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto
import com.unsplash.pickerandroid.photopicker.presentation.UnsplashPhotoAdapter

class PuppyAdapter(private val onClick: (Puppy) -> Unit) :
    ListAdapter<Puppy, PuppyAdapter.PuppyViewHolder>(DIFF_CONFIG) {

    class PuppyViewHolder(itemView: View, val onClick: (Puppy) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val puppyImage : ImageView = itemView.findViewById(R.id.puppyImage)
        private val puppyName : TextView = itemView.findViewById(R.id.puppyName)
        private val puppySex : TextView = itemView.findViewById(R.id.puppySex)
        private var currentPuppy: Puppy? = null

        init {
            itemView.setOnClickListener {
                currentPuppy?.let {
                    onClick(it)
                }
            }
        }

        fun bind(puppy : Puppy) {
            currentPuppy = puppy

            
            puppyImage.setImageResource(puppy.puppyImageId)
            puppyName.text = puppy.title.toString()
            puppySex.text = puppy.sex.toString()
        }
    }


    companion object {
        val DIFF_CONFIG = object : DiffUtil.ItemCallback<Puppy>() {
            override fun areItemsTheSame(oldItem: Puppy, newItem: Puppy): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Puppy, newItem: Puppy): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PuppyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_view, parent, false)
        return PuppyViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: PuppyViewHolder, position: Int) {
        val puppy = getItem(position)
        holder.bind(puppy)
    }
}