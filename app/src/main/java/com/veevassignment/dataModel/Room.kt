package com.veevassignment.dataModel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Room(
    val devices: List<Device>,
    val id: String,
    val name: String
) : Parcelable