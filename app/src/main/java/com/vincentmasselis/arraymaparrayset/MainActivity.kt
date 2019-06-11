package com.vincentmasselis.arraymaparrayset

import android.app.Activity
import android.os.Bundle

class MainActivity : Activity() {

    // Both of the properties should have a warning
    private val mutableMap = mutableMapOf<String, String>().toMutableMap()
    private val mutableSet = mutableSetOf<String>().toMutableSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mutableMap
        mutableSet
    }
}
