fun main() {
    // car Object
    var car = Car(color = "Yellow", model = "ZMMM")

    println(car.color)

    car.drive()
    car.speed(120, 133)

    val truck = Truck(color = "Magneta", model = "F16")
    truck.drive()

    val truck2 = Truck2(color = "Magneta", model = "F16")
    truck2.drive()
    truck2.speed(10, 20)
}

// Open - inheritance
open class Car(var color: String, var model: String) {

    init {
        if (color == "Yellow") {
            println("Yayy Yellow")
        } else {
            println("Not Yellow")
        }
    }

    fun drive() {
        println("Drive....vrooom $model")
    }

    open fun speed(minSpeed: Int, maxSpeed: Int) {
        println("Min speed is $minSpeed, Max speed is $maxSpeed")
    }
}

class Truck(color: String, model: String) : Car(color, model)

class Truck2(color: String, model: String) : Car(color, model) {
    override fun speed(minSpeed: Int, maxSpeed: Int) {
        println("SPeeed.....")
    }
}
