package com.lloyd.daggerdemo

import android.util.Log
import javax.inject.Inject

/*
Injecting the Car via constructor injection
 */
class Car @Inject constructor(engine: Engine, wheels: Wheels) {
    fun driveCar() {
        Log.d("Lloyd", "Driving car")
    }

    /*
    This will be automatically called by Dagger as soon as the Car object is created
     */
    @Inject
    fun enableRemote(remote: Remote) {
        remote.setListener(this)
    }
}