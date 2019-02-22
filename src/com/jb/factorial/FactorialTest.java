package com.jb.factorial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FactorialTest {

	@Test
	void testCalculateFactorial() {
		// Base Case
		// Expected 1
		long n = 1;
		assertEquals(1, Factorial.calculateFactorial(n)); 
		
		// Tests
		// Expected 120
		n = 5;
		assertEquals(120, Factorial.calculateFactorial(n)); 
		
		// Expected 720
		n = 6;
		assertEquals(720, Factorial.calculateFactorial(n)); 
		
		// Expected 1
		n = 0;
		assertEquals(1, Factorial.calculateFactorial(n)); 
		
		// Expected 3628800
		n = 10;
		assertEquals(3628800, Factorial.calculateFactorial(n)); 
	}

}
