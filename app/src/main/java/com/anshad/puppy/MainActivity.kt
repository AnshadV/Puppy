package com.anshad.puppy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.anshad.data.Puppy
import com.anshad.puppyList.PuppyAdapter
import com.anshad.puppyList.PuppyListViewModel
import com.anshad.puppyList.PuppyListViewModelFactory
import com.anshad.puppyDetail.PuppyDetailActivity
import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker

const val PUPPY_ID = "puppy id"

class MainActivity : AppCompatActivity() {
    private val puppyListViewModel by viewModels<PuppyListViewModel> {
        PuppyListViewModelFactory(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val puppyAdapter = PuppyAdapter { puppy ->  adapterOnclick(puppy) }
        val concatAdapter = ConcatAdapter(puppyAdapter)

        val recyclerView: RecyclerView = findViewById(R.id.puppyList)
        recyclerView.adapter= concatAdapter



        puppyListViewModel.puppyLiveData.observe(this, {
            it?.let {
                puppyAdapter.submitList(it as MutableList<Puppy>)
            }
        })




    }

    private fun adapterOnclick(puppy: Puppy) {
        val intent = Intent(this, PuppyDetailActivity()::class.java)
        intent.putExtra(PUPPY_ID, puppy.id)
        Log.i("Onclick", "Reached")
        startActivity(intent)
    }
}