package com.lloyd.daggerdemo

import dagger.Module
import dagger.Provides

@Module
class EngineModule {

    @Provides
    fun provideEngine(petrolEngine: PetrolEngine): Engine {
        return petrolEngine
    }
}