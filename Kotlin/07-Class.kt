fun main() {
    // car Object
    var car = Car(color = "Yellow", model = "ZMMM")
     
    println(car.color)
    
    car.drive()
    car.speed(120, 133)
 }
 
 // Blueprint
 // Class is a set of object which shares common characteristics/ behavior and common properties/ attributes.
 class Car(var color: String, var model: String) {
     
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
     
     fun speed(minSpeed: Int, maxSpeed: Int) {
         println("Min speed is $minSpeed, Max speed is $maxSpeed")
     }
 }