package pattern.visitor

class Monitor(): ComputerPart {
    override fun accept(computerPartVisitor: ComputerPartVisitor) {
        computerPartVisitor.visitor(this)
    }
}