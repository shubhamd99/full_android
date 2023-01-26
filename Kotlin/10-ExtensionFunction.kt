fun main() {
    println("Hello Jenny".append("Friend"))
    println("Hello Jenny".append2("Friend"))
    println("Hello Jenny".removeFirstAndLastChars())
}

// Kotlin Extension Function Kotlin extension function provides a facility
// to "add" methods to class without inheriting a class or using any type of design pattern
fun String.append(toAppend: String): String {
    return this.plus(" $toAppend")
}

fun String.append2(toAppend: String): String = this.plus(" $toAppend")

fun String.removeFirstAndLastChars(): String = this.substring(1, this.length - 1)
