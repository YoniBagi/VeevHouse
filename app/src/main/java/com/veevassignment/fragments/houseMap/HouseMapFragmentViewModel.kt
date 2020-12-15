package com.veevassignment.fragments.houseMap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.veevassignment.dataModel.Room
import com.veevassignment.dataModel.VeevHouse
import com.veevassignment.managers.InjectionCreator
import com.veevassignment.utils.SingleLiveData
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.launch

class HouseMapFragmentViewModel: ViewModel() {
    private val veevHouseMLD = SingleLiveData<VeevHouse>()
    private val fragmentModel = InjectionCreator.getHouseMapFragmentModel()
    private val dataFetchingProgressMLD = SingleLiveData<Boolean>()
    private val errorMLD = MutableLiveData(false)
    private val proceedToRoomScreenMLD = SingleLiveData<Room>()


    fun getVeevHouse(): LiveData<VeevHouse>? = veevHouseMLD
    fun getErrorMLD(): LiveData<Boolean> = errorMLD
    fun getDataFetchingProgressMLD(): LiveData<Boolean> = dataFetchingProgressMLD
    fun getProceedToRoomScreenMLD(): LiveData<Room> = proceedToRoomScreenMLD

    fun onResume() {
        viewModelScope.launch {
            val veevHouse = fragmentModel.fetchVeevHouse()
                .onStart { dataFetchingProgressMLD.postValue(true) }
                .onCompletion { dataFetchingProgressMLD.postValue(false) }
                .catch { errorMLD.postValue(true) }
                .singleOrNull()
            veevHouseMLD.postValue(veevHouse)
        }
    }

    fun proceedToLivingRoomScreen(){
        veevHouseMLD.value?.let { proceedToRoomScreenMLD.postValue(it.rooms[1]) }
    }

    fun proceedToOfficeRoomScreen(){
        veevHouseMLD.value?.let { proceedToRoomScreenMLD.postValue(it.rooms[0]) }
    }
}