package com.example;

import org.junit.Test; // 4.12

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;


public class CalculatorTest {

    //@Test(expected = ArithmeticException.class)
    @Test
    public void testAdd_small_numbers() {
        // Arrange
        Calculator calculator = new Calculator();

        ArrayList<CalcData> allData = new CalcDataDAO().getAllCalcData();

        for( CalcData one : allData) {
            double actual_result = calculator.add(one.A, one.B);
        }

        // Act
        double actual_result = calculator.add(3, 4);

        // Assert
        // compare between actual result and expected result
        //double expected_result = 7;

        assertEquals(7, actual_result);

        assertEquals("one", "one");
    }

    // test_min_...
    // test_mul_...
    // test_div_...
}
