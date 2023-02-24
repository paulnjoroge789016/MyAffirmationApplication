package com.example.myaffirmationapplication.data

import com.example.myaffirmationapplication.R
import com.example.myaffirmationapplication.model.Affirmation

class Datasource {
    fun loadAffirmations() = listOf<Affirmation>(
        Affirmation(R.string.affirmation2, R.drawable.image2),
        Affirmation(R.string.affirmation3, R.drawable.image3),
        Affirmation(R.string.affirmation4, R.drawable.image4)
    )
}