### In this branch lets see how Dagger injects the methods via method injection. Consider a Car has a remote and we need to connect the remote to Car

**Remote**

```
import android.util.Log
import javax.inject.Inject

class Remote @Inject constructor() {

    fun setListener(car: Car) {
        Log.d("Lloyd", "Remote connected")
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
class Car @Inject constructor(engine: Engine, wheels: Wheels) {
    fun driveCar() {
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

As soon as your run the program the `Remote Connected` Log will be displayed. We are not calling `enableRemote()` manually the dagger itself calls it while creating the `Car` object.
