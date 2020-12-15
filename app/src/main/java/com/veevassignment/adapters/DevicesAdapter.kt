package com.veevassignment.adapters

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.veevassignment.R
import com.veevassignment.dataModel.Device
import com.veevassignment.databinding.AdapterDevicesListBinding

class DevicesAdapter(private val devices: List<Device>) :
    RecyclerView.Adapter<DevicesAdapter.DeviceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        val binding = DataBindingUtil.inflate<AdapterDevicesListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.adapter_devices_list,
            parent,
            false
        )
        return DeviceViewHolder(binding)
    }

    override fun getItemCount() = devices.size

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {
        holder.onBind(devices[position])
    }

    inner class DeviceViewHolder(private val binding: AdapterDevicesListBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(device: Device) {
            binding.deviceViewHolder = this
            binding.nameDevice.text = device.name
            binding.switchState.isChecked = TextUtils.equals("true", device.state)
        }

    }
}