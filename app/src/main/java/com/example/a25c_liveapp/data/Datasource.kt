package com.example.a25c_liveapp.data

import com.example.a25c_liveapp.R
import com.example.a25c_liveapp.data.model.Fan

class Datasource() {

    fun loadFans(): List<Fan> {
        return listOf(
            Fan(
                "refresh MX300",
                45.99,
                R.drawable.fan1,
                false
            ),
            Fan(
                "Cool Office i2",
                20.39,
                R.drawable.fan2,
                false
            ),
            Fan(
                "Vintage Wind 74",
                79.99,
                R.drawable.fan3,
                true
            ),
            Fan(
                "Cool Breeze",
                102.75,
                R.drawable.fan1,
                false
            ),
            Fan(
                "Classic Budget",
                12.99,
                R.drawable.fan2,
                true
            )
        )
    }
}
