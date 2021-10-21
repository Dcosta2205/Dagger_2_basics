package com.lloyd.daggerdemo

import dagger.Module
import dagger.Provides

@Module
class EngineModule constructor(val horsePower: Int) {

    @Provides
    fun provideEngine(): Engine {
        return PetrolEngine(horsePower)
    }
}