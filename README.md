## Lets imagine a owner has 2 cars but he has only one driver who will drive both the vehicles.

Lets consider the below driver class

**Driver**

```

import javax.inject.Inject

class Driver @Inject constructor()
```

Now since our car has a driver, lets add our driver there

**Car**

```

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
```

Now since we have 2 cars and one driver, lets see what happens when I run the below code

**MainActivity**

```
class MainActivity : AppCompatActivity() {
    /*
    When using field injection make sure the field is public or else Dagger will throw an error
    as it cannot find the object to instantiate
     */
    @Inject
    lateinit var car1: Car

    @Inject
    lateinit var car2: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerCarComponent.builder().engineModule(EngineModule(120)).build().inject(this)
        car1.driveCar()
        car2.driveCar()
    }
}
```

**Output**

```
com.lloyd.daggerdemo.Driver@47f5102 is driving car com.lloyd.daggerdemo.Car@e704a13
com.lloyd.daggerdemo.Driver@a138450 is driving car com.lloyd.daggerdemo.Car@27fe649
```

From the above it is clear that even though we have just one driver we are getting two different driver objects (@47f5102 and @a138450).

## How to deal with singleton?

**Driver**


```
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Driver @Inject constructor()
```

Also annotate `CarComponent` with @SingleTon

```
import dagger.Component
import javax.inject.Singleton

/*
This is an important interface which will help our activity to find the Car class.
This works on annotation processor.

Make sure to include all the modules
 */
@Singleton
@Component(modules = [WheelModule::class, EngineModule::class])
interface CarComponent {

    /*
    Since we do not write any constructors for Activities in Android we need to inject the
    activity so that any Fields with @inject declared in Activities can be found.
     */
    fun inject(mainActivity: MainActivity)
}
```

**Output**


```
com.lloyd.daggerdemo.Driver@47f5102 is driving car com.lloyd.daggerdemo.Car@e704a13
com.lloyd.daggerdemo.Driver@47f5102 is driving car com.lloyd.daggerdemo.Car@a138450
```

From the output it is clear that we have same drivers for both the cars.

**Note**

If the dependency is recieved via @Provides then annotate the method with @SingleTon
