package pattern.visitor

interface ComputerPart {
    fun accept(computerPartVisitor: ComputerPartVisitor)
}