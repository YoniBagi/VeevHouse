package com.veevassignment.managers.roomManager

import com.veevassignment.dataModel.Device
import com.veevassignment.dataModel.Room

interface RoomManagerContract {

    fun getRooms(): List<Room>?

    fun changeStateDevice( device: Device)
}