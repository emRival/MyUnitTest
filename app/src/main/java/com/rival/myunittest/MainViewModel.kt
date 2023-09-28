package com.rival.myunittest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rival.myunittest.model.CuboidModel

class MainViewModel() : ViewModel() {

    private val cuboidModel: CuboidModel = CuboidModel()

    private val _result = MutableLiveData<Double>()
    val result: LiveData<Double> = _result

    fun getCircumference() {
        _result.value = cuboidModel.getCircumference()
    }

    fun getSurfaceArea() {
        _result.value = cuboidModel.getSurfaceArea()
    }

    fun getVolume() {
        _result.value = cuboidModel.getVolume()
    }

    fun save(w: Double, l: Double, h: Double) {
        cuboidModel.save(w, l, h)
    }

}