package com.lloyd.daggerdemo

import android.util.Log
import javax.inject.Inject

class PetrolEngine @Inject constructor() : Engine {
    override fun startEngine() {
        Log.d("Lloyd", "Starting petrol engine")
    }
}