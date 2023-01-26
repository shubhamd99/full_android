fun main() {
    // Lambda - (a function without a name)
    println(add(12, 13))
    println(calculateAge(12))
    println(calculateAge2(22))
    name("SHubham")

    enhancedMessage(message = "Hello There,") {
        print(it)
        add(12, 12)
    }
}

val add: (Int, Int) -> Int = { a, b -> a + b }

val calculateAge: (Int) -> Int = { age -> age * 7 }

// Simplify for one param
val calculateAge2: (Int) -> Int = { it * 7 }

// Func with No Return
val name: (String) -> Unit = { println(it) }

// Trailing Lambda
fun enhancedMessage(message: String, funAsParam: (String) -> Int) {
    println("$message ${funAsParam("Hey, ")}")
}
