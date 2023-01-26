fun main() {
    val button = Button("DVX")
    button.onClick("Hello")
}

// Interfaces in Kotlin can contain declarations of abstract methods, as well as method
// implementations
interface ClickEvent {
    fun onClick(message: String)
}

class Button(val label: String) : ClickEvent {
    override fun onClick(message: String) {
        println("Clicked: $message $label")
    }
}
