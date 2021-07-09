package com.example.counter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(val handle: SavedStateHandle) :ViewModel() {
    private var count = 0
        set(value) {
            field = value
            countLiveData.value = count
        }

    val countLiveData = MutableLiveData<Int>()

    fun increaseCount(){
        count++
    }
    fun decreaseCount(){
        count--
    }
}