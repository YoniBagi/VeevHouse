package com.veevassignment.managers

import com.veevassignment.fragments.houseMap.HouseMapContract
import com.veevassignment.fragments.houseMap.HouseMapFragmentModel

object InjectionCreator {

    fun getHouseMapFragmentModel(): HouseMapContract.IModel =
        HouseMapFragmentModel()
}