package com.example.giftsnap.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giftsnap.server.entity.Gift
import com.example.giftsnap.server.repository.GiftRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GiftViewModel1 @Inject constructor(
    private val repository: GiftRepository
) : ViewModel() {
    val gifts: LiveData<List<Gift>> = repository.gifts

    fun insert(gift: Gift) = viewModelScope.launch {
        repository.insert(gift)
    }

    fun update(gift: Gift) = viewModelScope.launch {
        repository.update(gift)
    }

    fun delete(gift: Gift) = viewModelScope.launch {
        repository.delete(gift)
    }
}


@HiltViewModel
class GiftViewModel @Inject constructor(
    private val repository: GiftRepository
) : ViewModel() {
    private val _giftEntries = MutableLiveData<List<Gift>>()
    val gifts: LiveData<List<Gift>> = _giftEntries

    init {
        loadGiftEntries()
    }

    private fun loadGiftEntries() {
        viewModelScope.launch {
            try {
                val entries = repository.gifts
                _giftEntries.value = entries.value
            } catch (e: Exception) {
                Log.e("GiftEntryViewModel", "Failed to load gift entries", e)
            }
        }
    }
}