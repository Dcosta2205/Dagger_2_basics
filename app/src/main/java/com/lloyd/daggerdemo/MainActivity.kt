package com.lloyd.daggerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        Getting the car object from component class. DaggerCarComponent class is generated at
        compile time and it internally generates all the required dependencies
         */
        car = DaggerCarComponent.create().getCar()
        car.driveCar()
    }
}