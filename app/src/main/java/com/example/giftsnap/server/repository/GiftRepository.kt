package com.example.giftsnap.server.repository

import androidx.lifecycle.LiveData
import com.example.giftsnap.server.dao.GiftDao
import com.example.giftsnap.server.entity.Gift

class GiftRepository(private val giftDao: GiftDao) {

    val gifts: LiveData<List<Gift>> = giftDao.getAllGifts()

    suspend fun insert(gift: Gift) {
        giftDao.insert(gift)
    }

    suspend fun update(gift: Gift) {
        giftDao.update(gift)
    }

    suspend fun delete(gift: Gift) {
        giftDao.delete(gift)
    }
}