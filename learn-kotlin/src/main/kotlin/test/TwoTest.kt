package test

import org.junit.Ignore
import org.junit.Test

class TwoTest {
    @Test
    fun two(){
        println("two ....")
    }
    @Ignore("Ignore four ...")
    @Test
    fun four(){
        println("four ...")
    }
}