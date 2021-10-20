## In this sample we will look at the use of @module and @provides

In real projects we use most of the libraries where we don't have control over the classes and we cannot use constructor injection. Consider the below example

### We have Wheels class and it has dependency on Tyres and Rims. Imagine we are not manufacturing the tyres and Rims and getting it from third party vendors. How do I get the dependency of Tyre and Rim?

**Tyres**


```
/**
 * Imagine we are getting the tyres from third party and we cannot modify the class
 */
class Tyres
```

**Rim**

```
/**
 * Imagine we are getting the Rims from third party and we cannot modify the class
 */
class Rim
```

**Wheeks**

```
/*
Injecting Wheels via constructor
 */
class Wheels constructor(tyres: Tyres, rim: Rim)
```

Since `Tyres` and `Rim` are from third party, Dagger will fail to create the objects for them as we cannot annotate with @Inject inside those classes.

So we need to create a class called `WheeModule` and provide all the necessary objects


**WheelModule**

```

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
```

**CarComponent**


```
import dagger.Component

/*
This is an important interface which will help our activity to find the Car class.
This works on annotation processor.

Make sure to include all the modules
 */
@Component(modules = [WheelModule::class])
interface CarComponent {

    /*
    Since we do not write any constructors for Activities in Android we need to inject the
    activity so that any Fields with @inject declared in Activities can be found.
     */
    fun inject(mainActivity: MainActivity)
}
```


