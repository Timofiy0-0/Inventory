package com.tima.inventory

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    var price:Long,
    var quantity:Long,

)

