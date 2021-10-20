package com.lloyd.daggerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        In order to create an object of car we need to create the Engine and wheel objects
        as car has a dependency on Engine and Wheels.

        Engine might also have dependency on Cylinder, piston etc
        Wheels might also have dependency on Tyres, Rims etc

        So we end up creating many objects in order to create a car object
         */
        val engine = Engine()
        val wheels = Wheels()
        val car = Car(engine, wheels)
        car.driveCar()
    }
}