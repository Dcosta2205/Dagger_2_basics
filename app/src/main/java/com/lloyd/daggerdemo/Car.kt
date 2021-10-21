package com.lloyd.daggerdemo

import android.util.Log
import javax.inject.Inject

/*
Injecting the Car via constructor injection
 */
class Car @Inject constructor(val engine: Engine, wheels: Wheels, val driver: Driver) {
    fun driveCar() {
        engine.startEngine()
        Log.d("Lloyd", "${driver} is driving car $this")
    }

    /*
    This will be automatically called by Dagger as soon as the Car object is created
     */
    @Inject
    fun enableRemote(remote: Remote) {
        remote.setListener(this)
    }
}