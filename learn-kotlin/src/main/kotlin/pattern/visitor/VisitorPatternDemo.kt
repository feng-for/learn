package pattern.visitor

class VisitorPatternDemo

fun main(){
    Computer().accept(ComputerPartDisplayVisitor())
}