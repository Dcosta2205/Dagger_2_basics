## In this sample we will look at the dependency injection Dagger basics 

**Branch master**

Lets consider the example of car.

Car has Engine and Wheels
Engine has Cylinder, piston 
Wheels has tyres and Rims

and these dependency continues

**Engine**

```
class Engine
```

**Wheels**

```
class Wheels
```

**Car**

```
class Car constructor(engine: Engine, wheels: Wheels) {
    fun driveCar() {
        Log.d("Lloyd", "Driving car")
    }
}
```

### How to call the `driveCar()` method ?

```
      /*
        In order to create an object of car we need to create the Engine and wheel objects
        as car has a dependency on Engine and Wheels.

        Engine might also have dependency on Cylinder, piston etc
        Wheels might also have dependency on Tyres, Rims etc

        So we end up creating many objects in order to create a car object
         */
        val engine = Engine()
        val wheels = Wheels()
        val car = Car(engine, wheels)
        car.driveCar()
```

**Note**

Make sure you check the branches in the following order

1. master
2. constructor_injection
3. field_injection
4. method_injection
