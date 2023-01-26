/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    sayHello()
    calculate(1, 20)
    calculate(second = 3, first = 1) // Named Args
    println("CatAge: ${catAgeCalc(10)}")
    println("CatAge: ${catAgeCalc2(20)}")
}

fun sayHello() {
    println("This is a function")
}

// Function params
fun calculate(first: Int, second: Int) {
    for (i in first..second) {
        println("calculate: $i")
    }
}

// Return value
fun catAgeCalc(age: Int): Int {
    val catAge = age * 7
    return catAge
}

// Short func
fun catAgeCalc2(age: Int): Boolean = age > 7



