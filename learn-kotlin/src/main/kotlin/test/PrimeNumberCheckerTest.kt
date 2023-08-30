package test

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.*
import kotlin.properties.Delegates

// 步骤一: 指定定参数运行器
@RunWith(Parameterized::class)
class PrimeNumberCheckerTest(private var inputNumber: Int, private var expectedResult: Boolean) {

    /**
     * 步骤二：声明变量
     */
    // private var inputNumber by Delegates.notNull<Int>()
    // private var expectedResult: Boolean by Delegates.notNull()

    /**
     * 步骤三：为测试类声明一个带有参数的公共构造函数，为变量赋值
     */
    // constructor(inputNumber: Int , expectedResult: Boolean): this() {
    //     this.inputNumber = inputNumber;
    //     this.expectedResult = expectedResult;
    // }

    companion object {
        /**
         * 步骤四：为测试类声明一个使用注解 org.junit.runners.Parameterized.Parameters 修饰的，返回值为
         * java.util.Collection 的公共静态方法，并在此方法中初始化所有需要测试的参数对
         *  1）该方法必须由Parameters注解修饰
         *  2）该方法必须为public static的
         *  3）该方法必须返回Collection类型
         *  4）该方法的名字不做要求
         *  5）该方法没有参数
         */
        @JvmStatic
        @Parameterized.Parameters
        fun primeNumbers(): Collection<Array<Any>> {
            return listOf(
                arrayOf(2, true),
                arrayOf(6, false),
                arrayOf(19, true),
                arrayOf(22, false),
                arrayOf(23, true)
            )
        }
    }

    @Test
    fun testPrimeNumberChecker() {
        println("Parameterized Number is : $inputNumber");
        Assert.assertEquals(expectedResult, validate(inputNumber));
    }

    private fun validate(primeNumber: Int): Boolean {
        for (i in 2 until (primeNumber / 2)) {
            if (primeNumber % i == 0) {
                return false
            }
        }
        return true
    }

}