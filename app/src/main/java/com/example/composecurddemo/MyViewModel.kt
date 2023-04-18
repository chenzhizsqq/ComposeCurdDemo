package com.example.composecurddemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val _items = MutableLiveData(listOf("Item 1", "Item 2", "Item 3"))
    val items: LiveData<List<String>> = _items

    fun addItem(item: String) {
        _items.value = _items.value.orEmpty() + item
    }
}