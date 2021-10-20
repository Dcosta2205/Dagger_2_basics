package com.lloyd.daggerdemo

import android.util.Log
import javax.inject.Inject

class Remote @Inject constructor() {

    fun setListener(car: Car) {
        Log.d("Lloyd", "Remote connected")
    }
}