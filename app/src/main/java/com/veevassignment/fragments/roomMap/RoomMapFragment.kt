package com.veevassignment.fragments.roomMap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.veevassignment.R
import com.veevassignment.adapters.RoomViewPagerAdapter
import com.veevassignment.dataModel.Room
import com.veevassignment.databinding.FragmentRoomMapBinding
import com.veevassignment.enums.ItemsViewPagerEnum
import com.veevassignment.utils.Consts

class RoomMapFragment : Fragment() {
    private lateinit var mBinding: FragmentRoomMapBinding
    private lateinit var mViewModel: RoomMapFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewModel()
    }

    private fun setViewModel() {
        mViewModel = ViewModelProvider(this).get(RoomMapFragmentViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(container?.context),
            R.layout.fragment_room_map, container, false
        )
        setBinding()
        return mBinding.root
    }

    private fun setBinding() {
        mBinding.roomMapFragmentViewModel = mViewModel
        mBinding.lifecycleOwner = this
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val room = arguments?.getParcelable<Room>(Consts.KEY_BUNDLE_ROOM)
        room?.let {
            mBinding.viewPager.adapter = RoomViewPagerAdapter(this, it)
            TabLayoutMediator(mBinding.tabLayout, mBinding.viewPager){
                    tab, position -> tab.text = ItemsViewPagerEnum.getName(position)
            }.attach()
        }
    }
}
