package com.gitlab.doxterh.aoc2022.day03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.gitlab.doxterh.aoc2022.day03.Data;

class Step1Test {
	
	@Test
	void shouldGetFirstCompartment() {
		assertEquals("vJrwpWtwJgWr", Step1.getFirstCompartment("vJrwpWtwJgWrhcsFMMfFFhFp"));
	}
	
	@Test
	void shouldGetSecondCompartment() {
		assertEquals("hcsFMMfFFhFp", Step1.getSecondCompartment("vJrwpWtwJgWrhcsFMMfFFhFp"));
	}

	@Test
	void shouldFindItemInFirstRuckSack() {
		assertEquals('p', Step1.findItemInDouble("vJrwpWtwJgWrhcsFMMfFFhFp"));
	}
	
	@Test
	void shouldFindItemInSecondRuckSack() {
		assertEquals('L', Step1.findItemInDouble("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"));
	}
	
	@Test
	void shouldFindItemInThirdRuckSack() {
		assertEquals('P', Step1.findItemInDouble("PmmdzqPrVvPwwTWBwg"));
	}
	
	@Test
	void shouldFindItemInFourthRuckSack() {
		assertEquals('v', Step1.findItemInDouble("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"));
	}
	
	@Test
	void shouldFindItemInFifthRuckSack() {
		assertEquals('t', Step1.findItemInDouble("ttgJtRGJQctTZtZT"));
	}
	
	@Test
	void shouldFindItemInSixthRuckSack() {
		assertEquals('s', Step1.findItemInDouble("CrZsJsPPZsGzwwsLwLmpwMDw"));
	}
	
	@Test
	void shouldGetItemPriority() {
		assertEquals(16, Step1.getPriority('p'));
		assertEquals(38, Step1.getPriority('L'));
		assertEquals(22, Step1.getPriority('v'));
		assertEquals(20, Step1.getPriority('t'));
		assertEquals(19, Step1.getPriority('s'));
		assertEquals(42, Step1.getPriority('P'));
	}
	
	@Test
	void shoudCalculateSumOfPriorityFromBackPacks() {
		String[] lines = Data.TEST.split("\n");
		assertEquals(157, Step1.calculateSumOfPrioritiesFromBackpack(lines));
	}
	

}
