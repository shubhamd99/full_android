fun main() {
    // Im-mutable List
   val myListOfNames = listOf("SHubham", "Sid", "Ayush")
   
   myListOfNames.forEach {
       println(it)
   }
   
   for (item in myListOfNames) {
       println(item)
   }
   
   // Mutable List
   val myMutableList = mutableListOf(12,34,56)
   myMutableList.add(0, 13)
   myMutableList.removeAt(1)
   println(myMutableList) // [13, 34, 56]
   println("Elements: ${myMutableList.size}")
   println("Get: ${myMutableList.get(2)} ${myMutableList[2]}")
   println("Index: ${myMutableList.indexOf(56)}")
   
   // Set (Unique elements, no order, im-mutable)
   val mySet = setOf("US", "MZ", "AU")
   println(mySet)
   val myMutableSet = mutableSetOf("US", "MZ", "AU")
   myMutableSet.add("US") // It will not add same value again
   println(myMutableSet)
   
   // Map (Key value pairs)
   val secretMap = mapOf("Up" to 1, "Down" to 2, "Left" to 3, "Right" to 4)
   println(secretMap)
   println(secretMap.keys)
   println(secretMap.values)
   
   if ("Up" in secretMap) println("Yes is in!")
   if (4 in secretMap.values) println("Yes 4 is in!")
   
   val secretMutableMap = mutableMapOf("Up" to 1, "Down" to 2, "Left" to 3, "Right" to 4)
   secretMutableMap.put("Shubham", 5)
   secretMutableMap["Sid"] = 10
   println(secretMutableMap)
   
   // Initializing List
   val myNewList = mutableListOf<String>()
   myNewList.add("Shubham")
   println(myNewList)
   
   // Empty collections
   val empty = emptyList<String>()
   val emptySet = emptySet<Int>()
   val emptyMap = emptyMap<Int, Int>()
   
   // Collection Filters
   val found = myListOfNames.filter {
       it == "Ayush"
   }
   val found2 = myListOfNames.filter {
       it.startsWith("S", ignoreCase = true) && it.endsWith("d")
   }
   println("found $found")
   println("found2 $found2")
}

