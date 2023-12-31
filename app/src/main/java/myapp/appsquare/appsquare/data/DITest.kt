package myapp.appsquare.appsquare.data

import android.util.Log
import javax.inject.Inject

data class Engine(val string: String)
data class Wheel(val string: String)

data class Car(val engine: Engine, val wheel: Wheel)


fun createCar(engine: Engine, wheel: Wheel) {

    val car = Car(engine, wheel)
}


class EngineTest {
    @Inject
    val test: String = ""


    @Inject
    fun typeCarName(){
        Log.e("TAG", "typeCarName: ", )
    }
}