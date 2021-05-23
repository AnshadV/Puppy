package com.anshad.puppyList

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anshad.data.PuppyRepository
import java.lang.IllegalArgumentException

class PuppyListViewModel(val dataSource: PuppyRepository) : ViewModel() {

    val puppyLiveData = dataSource.getPuppyList()

}

class PuppyListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PuppyListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PuppyListViewModel (
                dataSource = PuppyRepository.getDataSource(context.resources)
            )as T
            }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}