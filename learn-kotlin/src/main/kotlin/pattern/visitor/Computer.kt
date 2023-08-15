package pattern.visitor

class Computer(): ComputerPart {

    private val parts: Array<ComputerPart> = arrayOf(Keyboard(), Monitor(), Mouse())

    override fun accept(computerPartVisitor: ComputerPartVisitor) {
        parts.forEach { it.accept(computerPartVisitor) }
        computerPartVisitor.visitor(this)
    }
}