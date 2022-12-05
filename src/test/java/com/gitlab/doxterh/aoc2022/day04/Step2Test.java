package com.gitlab.doxterh.aoc2022.day04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Step2Test {

	@Test
	void shouldGetSection() {
		assertEquals(new Section(2, 4), Step2.getSection("2-4"));
		assertEquals(new Section(31, 28), Step2.getSection("31-28"));
		assertEquals(new Section(2, 4), Step2.getSection("4-2"));
	}

	@Test
	void shouldGetAssigmentPairs() {
		Section[] pairs = Step2.getAssignmentPair("2-4,6-8");

		assertEquals(new Section(2, 4), pairs[0]);
		assertEquals(new Section(6, 8), pairs[1]);
	}
	
	@Test
	void oneAssignmentShouldOverlapWithTheOther() {
		assertTrue(Step2.isPairOverlappedWithTheOther("5-7,7-9"));
		assertTrue(Step2.isPairOverlappedWithTheOther("2-8,3-7"));
		assertTrue(Step2.isPairOverlappedWithTheOther("6-6,4-6"));
		assertTrue(Step2.isPairOverlappedWithTheOther("2-6,4-8"));
	}
	
	@Test
	void oneAssignmentShouldNotOverlapWithTheOther() {
		assertFalse(Step2.isPairOverlappedWithTheOther("2-4,6-8"));
		assertFalse(Step2.isPairOverlappedWithTheOther("2-3,4-5"));		
	}
	
	@Test
	void shouldGetTotalOfFullyContainedPairs() {
		String[] lines = Data.TEST.split("\n");
		
		assertEquals(4, Step2.getTotalOfOverlappingPairs(lines));
		
	}

}
