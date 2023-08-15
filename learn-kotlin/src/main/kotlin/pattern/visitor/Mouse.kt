package pattern.visitor

class Mouse(): ComputerPart {
    override fun accept(computerPartVisitor: ComputerPartVisitor) {
        computerPartVisitor.visitor(this)
    }
}