package com.gitlab.doxterh.aoc2022.day13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class ValueTest {
	@Test
	void shouldParseListWithOnlyOneInteger() {

		Value value = new Value("[1]");
		assertEquals(1, value.elements.size());
		assertEquals("1", value.elements.get(0).toString());
	}
	
	@Test
	void shouldParseListWithOnlyOneIntegerWithTwoDigit() {

		Value value = new Value("[13]");
		assertEquals(1, value.elements.size());
		assertEquals("13", value.elements.get(0).toString());
	}
	
	@Test
	void shouldParseListWithTwoIntegers() {

		Value value = new Value("[1,2]");
		assertEquals(2, value.elements.size());
		assertEquals("1", value.elements.get(0).toString());
		assertEquals("2", value.elements.get(1).toString());
	}
	
	@Test
	void shouldParseListWithOnlySimpleIntegers() {

		Value value = new Value("[1,1,3,1,1]");
		assertEquals(5, value.elements.size());
		assertEquals("1", value.elements.get(0).toString());
		assertEquals("1", value.elements.get(1).toString());
		assertEquals("3", value.elements.get(2).toString());
		assertEquals("1", value.elements.get(3).toString());
		assertEquals("1", value.elements.get(4).toString());
	}
	
	@Test
	void shouldParseListWithOnlyIntegers() {

		Value value = new Value("[12,253,87]");
		assertEquals(3, value.elements.size());
		assertEquals("12", value.elements.get(0).toString());
		assertEquals("253", value.elements.get(1).toString());
		assertEquals("87", value.elements.get(2).toString());
	}
	
	@Test
	void shouldParseListWithSimpleList() {

		Value value = new Value("[[1],[2,3,4]]");
		assertEquals(2, value.elements.size());
		
		Value valueLeft = value.elements.get(0);
		assertEquals("[1]", valueLeft.toString());
		
		Value valueRight = value.elements.get(1);
		assertEquals("[2,3,4]", valueRight.toString());
	
		assertEquals(1, valueLeft.elements.size());
		assertEquals("1", valueLeft.elements.get(0).toString());
		
		assertEquals(3, valueRight.elements.size());
		assertEquals("2", valueRight.elements.get(0).toString());
		assertEquals("3", valueRight.elements.get(1).toString());
		assertEquals("4", valueRight.elements.get(2).toString());

	}
	
	
}
