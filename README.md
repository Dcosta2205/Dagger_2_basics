## In most of the Android projects few classes have dependency on context class, if the constructor of the class has a dependency on context, how will Dagger provide it?

Here in the previous example(branch `interface_dependency`), we have a `PetrolEngine`. If this petrol engine takes an `horsePower` as the parameter in the constructor, how will Dagger provide it ? As the power is decided at runtime and not compile time.

**PetrolEngine**

```
import android.util.Log

class PetrolEngine constructor(val horsepower: Int) : Engine {
    override fun startEngine() {
        Log.d("Lloyd", "Starting petrol engine with power $horsepower")
    }
}
```

I have removed `@Inject` in the constructor declaration as the Dagger doesn't know from where to provide the horsepower.

**EngineModule**

```
import dagger.Module
import dagger.Provides

@Module
class EngineModule constructor(val horsePower: Int) {

    @Provides
    fun provideEngine(): Engine {
        return PetrolEngine(horsePower)
    }
}
```

Now the generated `DaggerCarComponent` won't have method `create()` as one of the module has a runtime dependency. Here we will be using the `builder()` as follows

```
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
```
