package com.veevassignment.managers.roomManager

import android.text.TextUtils
import com.veevassignment.dataModel.Device
import com.veevassignment.dataModel.Room

object RoomManager : RoomManagerContract {
    private var rooms: List<Room> = mutableListOf()

    override fun getRooms() = rooms

    override fun changeStateDevice(device: Device) {
        val newRooms = rooms.map { room ->
            room.devices.map {
                if (TextUtils.equals(it.id, device.id)) {
                    it.state = (!it.getBooleanState()).toString()
                }
                else {it}
            }
        }
    }


}