package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals("Sum check failed", 5, 2 + 3);
        System.out.println(" Math check: 2 + 3 = 5 confirmed!");

        // Assert true
        assertTrue("True condition failed", 5 > 3);
        System.out.println(" Logical truth: 5 is indeed greater than 3.");

        // Assert false
        assertFalse("False condition failed", 5 < 3);
        System.out.println(" Confirmed: 5 is not less than 3.");

        // Assert null
        Object nullObj = null;
        assertNull("Object should be null", nullObj);
        System.out.println(" Memory check: Object is correctly null.");

        // Assert not null
        Object obj = new Object();
        assertNotNull("Object should not be null", obj);
        System.out.println(" Memory check: Object is not null and exists.");

        System.out.println(" All JUnit assertions executed successfully without failures!");
    }
}
