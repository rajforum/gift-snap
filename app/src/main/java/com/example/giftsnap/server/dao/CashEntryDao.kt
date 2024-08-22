package com.example.giftsnap.server.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.giftsnap.server.entity.CashEntry

@Dao
interface CashEntryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cashEntry: CashEntry)

    @Update
    suspend fun update(cashEntry: CashEntry)

    @Delete
    suspend fun delete(cashEntry: CashEntry)

    @Query("SELECT * FROM cash_entry ORDER BY date DESC")
    fun getAllCashEntries(): LiveData<List<CashEntry>>

    @Query("SELECT * FROM cash_entry WHERE id = :id")
    fun getCashEntryById(id: Long): LiveData<CashEntry>
}