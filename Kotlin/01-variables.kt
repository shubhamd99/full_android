/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    // Mutable
    var myName = "Shubham"
    myName = "Shubham D."
    println("Hello, $myName")
    
    // Im-mutable
    val myName2 = "Shubham2"
    println("Hello, $myName2")
    
    // Initializing variables
    val myName3: String
    myName3 = "Shubham3"
    val age: Int
    age = 21
    println("Hello, $myName3, age: $age")
    
    // Basic Types
    val myByte: Byte
    myByte = 127 // Limit 127
    println(myByte)
    
    val myShort: Short
    myShort = 32767 // Limit 32,767
    println(myShort)

    // Long
    val number = 1
    val oneLong = 1L
    println("$number $oneLong")
   
    // FLoat
    val e = 2.7182818284 // 2.7182818284
    val eFloat = 2.7182818284f // 2.7182817
    val pi = 3.14f
    println("$e $eFloat $pi")
}