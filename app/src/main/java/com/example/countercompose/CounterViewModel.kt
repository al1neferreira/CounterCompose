package com.example.countercompose

import androidx.lifecycle.ViewModel

class CounterViewModel() : ViewModel() {

    private var count = 0

    fun getCount(): Int {
        return count
    }

    fun increment() {
        count += 1
    }

}