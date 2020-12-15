package com.veevassignment.enums

enum class ItemsViewPagerEnum(private val nameRoom: String, private val position: Int) {
    ROOM("room", 0),
    LIST("List", 1);

    companion object{
        fun getName(pos: Int):String{
            return when (pos){
                1 -> LIST.nameRoom
                else -> ROOM.nameRoom
            }
        }
    }

    fun toInt() = position
}