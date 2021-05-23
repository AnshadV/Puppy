package com.anshad.puppyDetail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.anshad.puppy.PUPPY_ID
import com.anshad.puppy.R

class PuppyDetailActivity : AppCompatActivity() {

    private val puppyDetailViewModel by viewModels<PuppyDetailViewModel> {
        PuppyDetailViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.puppy_detail_activity)

        var currentPuppyId: Long? = null

        val puppyName: TextView = findViewById(R.id.puppy_detail_name)
        val puppyImage: ImageView = findViewById(R.id.puppy_detail_image)
        val puppySex: TextView = findViewById(R.id.puppy_detail_sex)
        val puppyAge: TextView = findViewById(R.id.puppy_detail_age)

        val bundle: Bundle? = intent.extras
        if(bundle != null) {
            currentPuppyId = bundle.getLong(PUPPY_ID)
        }

        currentPuppyId?.let {
            val currentPuppy = puppyDetailViewModel.getPuppyId(it)
            puppyName.text = currentPuppy?.title
            if(currentPuppy?.puppyImageId == null) {
                puppyImage.setImageResource(R.drawable.dog1)
            } else {
                puppyImage.setImageResource(currentPuppy?.puppyImageId)
            }
            puppyAge.text = currentPuppy?.age.toString()

            puppySex.text = currentPuppy?.sex.toString()


        }
    }
}