package com.lloyd.daggerdemo

import dagger.Component

/*
This is an important interface which will help our activity to find the Car class.
This works on annotation processor.

Make sure to include all the modules
 */
@Component(modules = [WheelModule::class, EngineModule::class])
interface CarComponent {

    /*
    Since we do not write any constructors for Activities in Android we need to inject the
    activity so that any Fields with @inject declared in Activities can be found.
     */
    fun inject(mainActivity: MainActivity)
}