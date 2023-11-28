package com.gitlab.doxterh.aoc2022.day13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	
	@Test
	void shouldParseListWithNestedList() {

		Value value = new Value("[1,[2,[3,4]],5]");
		assertEquals(3, value.elements.size());
		
		Value value1 = value.elements.get(0);
		assertEquals("1", value1.toString());
		
		Value value2 = value.elements.get(1);
		assertEquals("[2,[3,4]]", value2.toString());
	
		Value value3 = value.elements.get(2);
		assertEquals("5", value3.toString());
		

	}
	
	@Test
	void shouldParseListWithComplexList() {

		Value value = new Value("[1,[2,[3,[4,[5,6,7]]]],8,9]");
		assertEquals(4, value.elements.size());
		
		Value value1 = value.elements.get(0);
		assertEquals("1", value1.toString());
		
		Value value2 = value.elements.get(1);
		assertEquals("[2,[3,[4,[5,6,7]]]]", value2.toString());
	
		Value value3 = value.elements.get(2);
		assertEquals("8", value3.toString());
		
		Value value4 = value.elements.get(3);
		assertEquals("9", value4.toString());

	}
	
	
	@Test
	void shouldParseEmptyList() {

		Value value = new Value("[[]]");
		assertEquals(1, value.elements.size());
		
		Value value1 = value.elements.get(0);
		assertTrue(value1.elements.isEmpty());
	}
	
	@Test
	void shouldParseNestedEmptyList() {

		Value value = new Value("[[[]]]");
		assertEquals(1, value.elements.size());
		
		Value value1 = value.elements.get(0);
		assertEquals(1, value1.elements.size());
		
		Value value2 = value1.elements.get(0);
		assertTrue(value2.elements.isEmpty());
	}
	
}
