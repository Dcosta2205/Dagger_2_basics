package com.lloyd.daggerdemo

import android.util.Log

class PetrolEngine constructor(val horsepower: Int) : Engine {
    override fun startEngine() {
        Log.d("Lloyd", "Starting petrol engine with power $horsepower")
    }
}