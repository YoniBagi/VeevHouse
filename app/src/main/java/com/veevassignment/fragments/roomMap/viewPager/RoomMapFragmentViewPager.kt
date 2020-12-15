package com.veevassignment.fragments.roomMap.viewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.veevassignment.R
import com.veevassignment.dataModel.Room
import com.veevassignment.enums.RoomTypeEnum
import com.veevassignment.utils.Consts
import kotlinx.android.synthetic.main.fragment_room_map_view_pager.*

class RoomMapFragmentViewPager: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_room_map_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(Consts.KEY_ROOM_MAP_VIEW_PAGER) }?.apply {
            val room = getParcelable<Room>(Consts.KEY_ROOM_MAP_VIEW_PAGER)
            room?.let {
                when(it.id){
                    RoomTypeEnum.OFFICE.getStringNum() -> ivRoomViewPager?.setImageResource(R.drawable.ic_office)
                    else -> ivRoomViewPager?.setImageResource(R.drawable.ic_living_room)
                }
            }

        }
    }
}