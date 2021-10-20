## In this sample lets see how to inject interface using Dagger. Since we cannot have any constructors in an interface lets create a class which implements the interface and handle it

**Engine**

```
interface Engine {

    fun startEngine()
}
```

Create a class which extends `Engine`

**PetrolEngine**

```
import android.util.Log
import javax.inject.Inject

class PetrolEngine @Inject constructor() : Engine {
    override fun startEngine() {
        Log.d("Lloyd", "Starting petrol engine")
    }
}
```

**Car**

```
import android.util.Log
import javax.inject.Inject

/*
Injecting the Car via constructor injection
 */
class Car @Inject constructor(val engine: Engine, wheels: Wheels) {
    fun driveCar() {
        engine.startEngine()
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
```

Now since `Engine` is an interface and it does not have any constructor dagger throws an error. We need to provide the `Engine`

**EngineModule**

```
import dagger.Module
import dagger.Provides

@Module
class EngineModule {

    /*
     Since we have injected `PetrolEngine` via constructor Dagger will get the object of it
     */
    @Provides
    fun provideEngine(petrolEngine: PetrolEngine): Engine {
        return petrolEngine
    }
}
```

Also make sure to include the `EngineModule` in the `CarComponent`

**CarComponent**

```

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
```


