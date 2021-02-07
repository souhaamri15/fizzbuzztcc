package com.souha.fizzbuzz;

import com.souha.fizzbuzz.core.FizzBuzzServiceTests;
import com.souha.fizzbuzz.main.ApplicationTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        FizzBuzzServiceTests.class, ApplicationTests.class
})
public class AllTests {
}
