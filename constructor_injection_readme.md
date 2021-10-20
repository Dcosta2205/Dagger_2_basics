Add the below dependencies in app/build.gradle

```
    implementation 'com.google.dagger:dagger:2.38.1'
    kapt 'com.google.dagger:dagger-compiler:2.38.1'
 ```
 
 Make sure to add the below plugin for annotation processor
 
 ```
     id 'kotlin-kapt'
```

## Change the classes as below

**Engine**

```

import javax.inject.Inject

/*
Injecting Engine via constructor
 */
class Engine @Inject constructor()
```

**Wheels**

```
import javax.inject.Inject

/*
Injecting Wheels via constructor
 */
class Wheels @Inject constructor()
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
}
```

**MainActivity**


```
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
```

