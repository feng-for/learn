package pattern.visitor

class Keyboard(): ComputerPart {
    override fun accept(computerPartVisitor: ComputerPartVisitor) {
        computerPartVisitor.visitor(this)
    }
}