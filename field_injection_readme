## Field Injection

```
/*
This is an important interface which will help our activity to find the Car class.
This works on annotation processor
 */
@Component
interface CarComponent {

    /*
    Since we do not write any constructors for Activities in Android we need to inject the
    activity so that any Fields with @inject declared in Activities can be found.
     */
    fun inject(mainActivity: MainActivity)
}
```

**MainActivity**

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
        DaggerCarComponent.create().inject(this)
        car.driveCar()
    }
}
```

## We can also apply the Field injection to Car class as below

```
/*
Injecting the Car via constructor injection and Engine, Wheels via Field injection
 */
class Car @Inject constructor(engine: Engine, wheels: Wheels) {
    @Inject
    lateinit var engine: Engine

    @Inject
    lateinit var wheels: Wheels
    fun driveCar() {
        Log.d("Lloyd", "Driving....")
    }
}
```
