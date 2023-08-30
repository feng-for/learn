package test

import org.junit.Ignore
import org.junit.Test

class OneTest {

    @Test
    fun one() {
        println("one ....")
    }

    @Ignore("Ignore three ...")
    @Test
    fun three() {
        println("three ...")
    }
}
