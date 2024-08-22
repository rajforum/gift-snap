package com.example.giftsnap.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giftsnap.server.entity.CashEntry
import com.example.giftsnap.server.repository.CashEntryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CashEntryViewModel1 @Inject constructor(
    private val repository: CashEntryRepository
) : ViewModel() {
    val cashEntries: LiveData<List<CashEntry>> = repository.cashEntries

    fun insert(cashEntry: CashEntry) = viewModelScope.launch {
        repository.insert(cashEntry)
    }

    fun update(cashEntry: CashEntry) = viewModelScope.launch {
        repository.update(cashEntry)
    }

    fun delete(cashEntry: CashEntry) = viewModelScope.launch {
        repository.delete(cashEntry)
    }
}

@HiltViewModel
class CashEntryViewModel @Inject constructor(
    private val repository: CashEntryRepository
) : ViewModel() {
    private val _cashEntries = MutableLiveData<List<CashEntry>>()
    val cashEntries: LiveData<List<CashEntry>> = _cashEntries

    init {
        loadCashEntries()
    }

    private fun loadCashEntries() {
        viewModelScope.launch {
            try {
                val entries = repository.cashEntries
                _cashEntries.value = entries.value
            } catch (e: Exception) {
                Log.e("CashEntryViewModel", "Failed to load cash entries", e)
            }
        }
    }
}
