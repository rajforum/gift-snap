package com.example.giftsnap.server.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "cash_entry")
data class CashEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val giverName: String,
    val amount: Double,
    val date: Date
)
