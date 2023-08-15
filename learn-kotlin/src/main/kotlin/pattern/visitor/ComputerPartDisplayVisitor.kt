package pattern.visitor

class ComputerPartDisplayVisitor(): ComputerPartVisitor {
    override fun visitor(keyboard: Keyboard) {
        println("Displaying Computer.")
    }

    override fun visitor(monitor: Monitor) {
        println("Displaying Monitor.")
    }

    override fun visitor(mouse: Mouse) {
        println("Displaying Mouse.")
    }

    override fun visitor(computer: Computer) {
        println("Displaying Computer.")
    }
}