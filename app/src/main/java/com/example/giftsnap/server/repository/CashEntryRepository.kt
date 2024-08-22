package com.example.giftsnap.server.repository

import androidx.lifecycle.LiveData
import com.example.giftsnap.server.dao.CashEntryDao
import com.example.giftsnap.server.entity.CashEntry

class CashEntryRepository(private val cashDao: CashEntryDao) {

    val cashEntries: LiveData<List<CashEntry>> = cashDao.getAllCashEntries()

    suspend fun insert(cashEntry: CashEntry) {
        cashDao.insert(cashEntry)
    }

    suspend fun update(cashEntry: CashEntry) {
        cashDao.update(cashEntry)
    }

    suspend fun delete(cashEntry: CashEntry) {
        cashDao.delete(cashEntry)
    }
}