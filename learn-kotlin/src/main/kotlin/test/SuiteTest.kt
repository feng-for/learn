package test

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(value = [OneTest::class, TwoTest::class, PrimeNumberCheckerTest::class])
class SuiteTest