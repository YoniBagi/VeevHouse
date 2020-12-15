package com.veevassignment.dataModel

import android.os.Parcelable
import android.text.TextUtils
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Device(
    val id: String,
    val name: String,
    val position: Position,
    val room: String,
    var state: String
) : Parcelable{

    fun getBooleanState() = TextUtils.equals("true", state)
}