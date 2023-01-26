fun main() {
    val person = Person(name = "Shubham", lastName = "Dhage", age = 25)
    val listOfPeople = listOf(person, Person("Sid", "CH", 29))
    println(person)
    println(listOfPeople)

    listOfPeople.forEach { item -> println(item.age) }
}

// To Hold Data
data class Person(val name: String, val lastName: String, val age: Int)
