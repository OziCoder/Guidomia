package com.example.guidomia.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import utils.AppConstants

@Entity(tableName = AppConstants.TABLE_CAR_DETAILS)
data class CarEntity(
    val consList: String,
    val customerPrice: Int,
    val make: String,
    val marketPrice: Int,
    val model: String,
    val prosList: String,
    val rating: Int,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
)
