package com.gitlab.doxterh.aoc2022.day04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.gitlab.doxterh.aoc2022.day04.Data;

class Step1Test {

	@Test
	void shouldGetSection() {
		assertEquals(new Section(2, 4), Step1.getSection("2-4"));
		assertEquals(new Section(31, 28), Step1.getSection("31-28"));
		assertEquals(new Section(2, 4), Step1.getSection("4-2"));
	}

	@Test
	void shouldGetAssigmentPairs() {
		Section[] pairs = Step1.getAssignmentPair("2-4,6-8");

		assertEquals(new Section(2, 4), pairs[0]);
		assertEquals(new Section(6, 8), pairs[1]);
	}
	
	@Test
	void oneAssignmentShouldBeFullyContainedByTheOther() {
		assertTrue(Step1.isPairContainedByTheOther("2-8,3-7"));
		assertTrue(Step1.isPairContainedByTheOther("6-6,4-6"));
		assertTrue(Step1.isPairContainedByTheOther("6-54,7-54"));
	}
	
	@Test
	void oneAssignmentShouldNotBeFullyContainedByTheOther() {
		assertFalse(Step1.isPairContainedByTheOther("2-4,6-8"));
		assertFalse(Step1.isPairContainedByTheOther("2-6,4-8"));
		assertFalse(Step1.isPairContainedByTheOther("13-15,15-16"));
		assertFalse(Step1.isPairContainedByTheOther("15-16,13-15"));
		
	}
	
	@Test
	void shouldGetTotalOfFullyContainedPairs() {
		String[] lines = Data.TEST.split("\n");
		
		assertEquals(2, Step1.getTotalOfFullyContainedPairs(lines));
		
	}

}
