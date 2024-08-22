package com.example.giftsnap.server.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "gift")
data class Gift(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val giverName: String,
    val description: String,
    val value: Double,
    val date: Date
)