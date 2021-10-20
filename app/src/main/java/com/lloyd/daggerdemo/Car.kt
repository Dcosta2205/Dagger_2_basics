package com.lloyd.daggerdemo

import android.util.Log

class Car constructor(engine: Engine, wheels: Wheels) {
    fun driveCar() {
        Log.d("Lloyd", "Driving car")
    }
}