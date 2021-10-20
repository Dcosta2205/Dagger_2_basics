package com.lloyd.daggerdemo

import dagger.Module
import dagger.Provides

@Module
class WheelModule {

    @Provides
    fun provideTyres(): Tyres {
        return Tyres()
    }

    @Provides
    fun provideRim(): Rim {
        return Rim()
    }

    @Provides
    fun provideWheels(rim: Rim, tyres: Tyres): Wheels {
        return Wheels(tyres, rim)
    }
}