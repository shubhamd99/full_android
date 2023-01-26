fun main() {
    val listOfItems = listOf("Rafale", "Gina", "Shubham")
    val finder = Finder(list = listOfItems)
    finder.findItem(elm = "Gina") { println("Found $it") }
    finder.findItem(elm = "") { println("Found $it") }

    val listOfNumbers = listOf(1, 2, 3)
    val finder2 = Finder(list = listOfNumbers)
    finder2.findItem(elm = 2) { println("Found $it") }
    finder2.findItem(elm = 0) { println("Found $it") }

    val person = Person("Ravita", "Timber", 23)
    val listOfPerson = listOf(person, Person("Shubham", "Dhage", 25), Person("SId", "Ch", 29))
    val finder3 = Finder(list = listOfPerson)
    finder3.findItem(elm = person) { println("Found $it") }
}

//  Generics are the powerful features that allow us to define classes, methods and
//  properties which are accessible using different data types
class Finder<T>(private val list: List<T>) {

    fun findItem(elm: T, foundItem: (elm: T?) -> Unit) {
        val itemFoundList = list.filter { it == elm }
        if (itemFoundList.isNullOrEmpty()) foundItem(null) else foundItem(itemFoundList.first())
    }
}

// To Hold Data
data class Person(val name: String, val lastName: String, val age: Int)
