package com.lloyd.daggerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    /*
    When using field injection make sure the field is public or else Dagger will throw an error
    as it cannot find the object to instantiate
     */
    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerCarComponent.builder().engineModule(EngineModule(120)).build().inject(this)
        car.driveCar()
    }
}