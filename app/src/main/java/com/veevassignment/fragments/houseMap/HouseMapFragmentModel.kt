package com.veevassignment.fragments.houseMap

import com.veevassignment.dataModel.VeevHouse
import com.veevassignment.fragments.houseMap.HouseMapContract
import com.veevassignment.network.NetworkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class HouseMapFragmentModel : HouseMapContract.IModel {

    override fun fetchVeevHouse(): Flow<VeevHouse> =
        flow {
            emit(NetworkManager.instanceServiceApi.fetchVeevHouse())
        }.flowOn(Dispatchers.IO)

}