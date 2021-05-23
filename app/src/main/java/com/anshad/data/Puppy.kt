package com.anshad.data

data class Puppy(
    val id : Long,
    val title: String,
    val sex: String,
    val age: Int,
    val puppyImageId: Int = 0
)
