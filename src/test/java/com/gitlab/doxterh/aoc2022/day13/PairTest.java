package com.gitlab.doxterh.aoc2022.day13;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class PairTest {
	@Test
	void shouldCompareTwoNumericList() {

		Pair pair = new Pair("[1,1,3,1,1]", "[1,1,5,1,1]");
		
		assertTrue(pair.isInRightOrder());
	}
	
	@Test
	void leftSideWithSmallerValueShouldBeInRightOrder() {

		Pair pair = new Pair("[[1],[2,3,4]]", "[[1],4]");
		
		assertTrue(pair.isInRightOrder());
	}
	
	@Test
	void rightSideWithSmallerValueShouldNotBeInRightOrder() {

		Pair pair = new Pair("[9]", "[[8,7,6]]");
		
		assertFalse(pair.isInRightOrder());
	}
	
	@Test
	void leftSideRunningOutOfItemsShouldBeInRightOrder() {

		Pair pair = new Pair("[[4,4],4,4]", "[[4,4],4,4,4]");
		
		assertTrue(pair.isInRightOrder());
	}
	
	@Test
	void rightSideRunningOutOfItemsShouldNotBeInRightOrder() {

		Pair pair = new Pair("[7,7,7,7]","[7,7,7]");
		
		assertFalse(pair.isInRightOrder());
	}
	
	@Test
	void shouldCompareTwoComplexList() {

		Pair pair = new Pair("[1,[2,[3,[4,[5,6,7]]]],8,9]","[1,[2,[3,[4,[5,6,0]]]],8,9]");
		
		assertFalse(pair.isInRightOrder());
	}
		
}
