package com.veevassignment.dataModel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Position(
    val x: String,
    val y: String
) : Parcelable