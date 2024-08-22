package com.example.giftsnap.server.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.giftsnap.server.entity.Gift

@Dao
interface GiftDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(gift: Gift)

    @Update
    suspend fun update(gift: Gift)

    @Delete
    suspend fun delete(gift: Gift)

    @Query("SELECT * FROM gift ORDER BY date DESC")
    fun getAllGifts(): LiveData<List<Gift>>

    @Query("SELECT * FROM gift WHERE id = :id")
    fun getGiftById(id: Long): LiveData<Gift>
}