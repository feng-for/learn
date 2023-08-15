class NumberTest {
    var i: Int = 0

    fun add(){
        i++
    }

    fun print(){
        println(i)
    }
}

fun main(){
    val numberTest = NumberTest()
    numberTest.add()
    numberTest.add()
    numberTest.add()
    numberTest.add()
    numberTest.print()
    val test = NumberTest()
    test.print()
}