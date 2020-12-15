package com.veevassignment.enums

enum class RoomTypeEnum(private val num: String) {
    OFFICE("1"),
    LIVING("2");

    fun getStringNum() = num
}