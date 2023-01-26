/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    // If Else
    val amount = 900
    if (amount == 1000) {
        println("First")
    } else if (amount >= 1000) {
        println("Second")
    } else {
        println("Third")
    }
    
    // When
    when(amount) {
        100 -> println("100")
        200 -> println("200")
        900 -> println("900")
        else -> {
            println("Else")
        }
    }
    
    // When with range
    when(amount) {
        in 100..900 -> println("100..200")
        !in 10..900 -> println("10..900")
        200 -> println("200")
        else -> {
            println("Else")
        }
    }
 }