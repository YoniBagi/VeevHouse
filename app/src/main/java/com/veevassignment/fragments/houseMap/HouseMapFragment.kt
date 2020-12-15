package com.veevassignment.fragments.houseMap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.veevassignment.R
import com.veevassignment.dataModel.Room
import com.veevassignment.dataModel.VeevHouse
import com.veevassignment.databinding.FragmentHouseMapBinding
import com.veevassignment.utils.Consts

class HouseMapFragment : Fragment() {

    private lateinit var mViewModel: HouseMapFragmentViewModel
    private var mBinding: FragmentHouseMapBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewModel()
    }

    private fun setViewModel() {
        mViewModel = ViewModelProvider(this).get(HouseMapFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHouseMapBinding>(
            LayoutInflater.from(container?.context),
            R.layout.fragment_house_map,
            container,
            false
        )
        setBinding(binding)
        setObservers()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        mViewModel.onResume()
    }

    private fun setObservers() {
        mViewModel.getVeevHouse()?.observe(viewLifecycleOwner, Observer {
            setDataViews(it)
        })

        mViewModel.getProceedToRoomScreenMLD().observe(viewLifecycleOwner, Observer {
            proceedToRoomScreen(it)
        })
    }

    private fun proceedToRoomScreen(room: Room?) {
        room?.let {
            val bundle = Bundle()
            bundle.putParcelable(Consts.KEY_BUNDLE_ROOM, room)
            NavHostFragment.findNavController(this).navigate(R.id.action_houseMapFragment_to_roomMapFragment, bundle)
        }
    }

    private fun setDataViews(veevHouse: VeevHouse?) {
        veevHouse?.let { mBinding?.veevHouse = it }
    }

    private fun setBinding(binding: FragmentHouseMapBinding) {
        mBinding = binding
        mBinding?.houseMapFragmentViewModel = mViewModel
        mBinding?.lifecycleOwner = this
    }

}
