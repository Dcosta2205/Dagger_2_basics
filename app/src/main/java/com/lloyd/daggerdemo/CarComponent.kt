package com.lloyd.daggerdemo

import dagger.Component

/*
This is an important interface which will help our activity to find the Car class.
This works on annotation processor
 */
@Component
interface CarComponent {

    fun getCar(): Car
}