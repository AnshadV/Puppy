package com.anshad.puppy

import android.content.res.Resources
import com.anshad.data.Puppy
fun puppyList(resources: Resources): List<Puppy> {
    return listOf(
        Puppy(
            id = 1,
            title = "Fio",
            sex = "Female",
            age = 20,
            puppyImageId = R.drawable.dog1
        ),
        Puppy(
            id = 2,
            title = "Bambi",
            sex = "Female",
            age = 6,
            puppyImageId = R.drawable.dog2
        ),
        Puppy(
            id = 3,
            title = "Birdie",
            sex = "Male",
            age = 8,
            puppyImageId = R.drawable.dog3
        ),
        Puppy(
            id = 4,
            title = "Daphne",
            sex = "Male",
            age = 10,
            puppyImageId = R.drawable.dog4
        ),
        Puppy(
            id = 5,
            title = "Hadley",
            sex = "Female",
            age = 12,
            puppyImageId = R.drawable.dog5
        ),
        Puppy(
            id = 6,
            title = "Lucy",
            sex = "Female",
            age = 8,
            puppyImageId = R.drawable.dog6
        ),
        Puppy(
            id = 7,
            title = "Ida",
            sex = "Male",
            age = 10,
            puppyImageId = R.drawable.dog7
        ),
        Puppy(
            id = 8,
            title = "Koko",
            sex = "Female",
            age = 9,
            puppyImageId = R.drawable.dog8
        ),
        Puppy(
            id = 9,
            title = "Lulu",
            sex = "Male",
            age = 7,
            puppyImageId = R.drawable.dog9
        )
    )


}