package pattern.visitor

interface ComputerPartVisitor {

    fun visitor(keyboard: Keyboard)

    fun visitor(monitor: Monitor)

    fun visitor(mouse: Mouse)

    fun visitor(computer: Computer)
}