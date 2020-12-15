package com.veevassignment.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.veevassignment.dataModel.Room
import com.veevassignment.enums.ItemsViewPagerEnum
import com.veevassignment.fragments.roomMap.viewPager.ConfigurationRoomFragmentViewPager
import com.veevassignment.fragments.roomMap.viewPager.RoomMapFragmentViewPager
import com.veevassignment.utils.Consts

const val NUM_OF_ITEMS = 2

class RoomViewPagerAdapter(fragment: Fragment, private val room: Room) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = NUM_OF_ITEMS

    override fun createFragment(position: Int): Fragment {

        val fragment = when (position) {
            ItemsViewPagerEnum.LIST.toInt() -> createConfigurationRoomFragment()
            else -> createRoomMapFragment()
        }
        fragment.arguments = Bundle().apply {
            putParcelable(Consts.KEY_ROOM_MAP_VIEW_PAGER, room)
        }
        return fragment
    }

    private fun createRoomMapFragment() = RoomMapFragmentViewPager()

    private fun createConfigurationRoomFragment() = ConfigurationRoomFragmentViewPager()
}