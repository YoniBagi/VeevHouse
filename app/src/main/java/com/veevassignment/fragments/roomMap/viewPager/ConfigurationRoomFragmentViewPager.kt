package com.veevassignment.fragments.roomMap.viewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.veevassignment.R
import com.veevassignment.adapters.DevicesAdapter
import com.veevassignment.dataModel.Device
import com.veevassignment.dataModel.Room
import com.veevassignment.utils.Consts
import kotlinx.android.synthetic.main.fragment_configuration_room_view_pager.*

class ConfigurationRoomFragmentViewPager: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_configuration_room_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { arg ->
            if (arg.containsKey(Consts.KEY_ROOM_MAP_VIEW_PAGER)){
                val room = arg.getParcelable<Room>(Consts.KEY_ROOM_MAP_VIEW_PAGER)
                room?.let {
                    setDeviceList(it.devices)
                }
            }
        }
    }

    private fun setDeviceList(devices: List<Device>) {
        rvDevices?.adapter = DevicesAdapter(devices)
    }
}