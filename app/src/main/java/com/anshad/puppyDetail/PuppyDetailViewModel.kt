package com.anshad.puppyDetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anshad.data.Puppy
import com.anshad.data.PuppyRepository
import java.lang.IllegalArgumentException

class PuppyDetailViewModel(private val datasource: PuppyRepository) : ViewModel() {

    fun getPuppyId(id: Long) : Puppy? {
        return datasource.getPuppyForId(id)
    }

}

class PuppyDetailViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PuppyDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PuppyDetailViewModel(
                datasource = PuppyRepository.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}