package com.anshad.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.anshad.puppy.puppyList

class PuppyRepository(resources: Resources) {

    private val initialPuppyList = puppyList(resources)
    private val puppyLiveData = MutableLiveData(initialPuppyList)

    fun getPuppyList(): LiveData<List<Puppy>> {
        return puppyLiveData
    }

    fun getPuppyForId(id: Long) : Puppy? {
        puppyLiveData.value?.let { puppy ->
            return puppy.firstOrNull{it.id == id}
        }
        return null
    }

    companion object {
        private var INSTANCE: PuppyRepository? = null


        fun getDataSource(resources: Resources): PuppyRepository {
            return synchronized(PuppyRepository::class) {
                val newInstance = INSTANCE ?: PuppyRepository(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }

}