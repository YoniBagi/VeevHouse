package com.veevassignment.fragments.houseMap

import com.veevassignment.dataModel.VeevHouse
import kotlinx.coroutines.flow.Flow

interface HouseMapContract {

    interface IModel{
        fun fetchVeevHouse() : Flow<VeevHouse>
    }

}