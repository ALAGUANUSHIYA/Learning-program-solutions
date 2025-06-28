package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println(" Setup complete: Calculator instance created.");
    }

    @After
    public void tearDown() {
        System.out.println(" Teardown complete: Calculator instance discarded.\n");
    }

    @Test
    public void testAddition() {
        System.out.println(" Arrange: Preparing inputs for addition.");
        int a = 10;
        int b = 5;
        System.out.println(" Act: Performing addition operation.");
        int result = calculator.add(a, b);
        System.out.println(" Assert: Verifying the result.");
        assertEquals("Addition failed", 15, result);
        System.out.println(" testAddition passed: " + a + " + " + b + " = " + result);
    }

    @Test
    public void testSubtraction() {
        System.out.println(" Arrange: Preparing inputs for subtraction.");
        int a = 9;
        int b = 4;
        System.out.println(" Act: Performing subtraction operation.");
        int result = calculator.subtract(a, b);
        System.out.println(" Assert: Verifying the result.");
        assertEquals("Subtraction failed", 5, result);
        System.out.println(" testSubtraction passed: " + a + " - " + b + " = " + result);
    }

    @Test
    public void testMultiplication() {
        System.out.println(" Arrange: Preparing inputs for multiplication.");
        int a = 3;
        int b = 7;
        System.out.println(" Act: Performing multiplication operation.");
        int result = calculator.multiply(a, b);
        System.out.println(" Assert: Verifying the result.");
        assertEquals("Multiplication failed", 21, result);
        System.out.println(" testMultiplication passed: " + a + " * " + b + " = " + result);
    }
}
