package com.gitlab.doxterh.aoc2022.day03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.gitlab.doxterh.aoc2022.day03.Data;

class Step2Test {
	


	@Test
	void shouldFindBadgeForFirstGroup() {
		String[] group = new String[] {"vJrwpWtwJgWrhcsFMMfFFhFp","jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL","PmmdzqPrVvPwwTWBwg"};
		assertEquals('r', Step2.findGroupBadge(group));
	}
	
	@Test
	void shouldFindBadgeForSecondGroup() {
		String[] group = new String[] {"wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn","ttgJtRGJQctTZtZT","CrZsJsPPZsGzwwsLwLmpwMDw"};
		assertEquals('Z', Step2.findGroupBadge(group));
	}
	
	
	@Test
	void shouldGetItemPriority() {
		assertEquals(18, Step2.getPriority('r'));
		assertEquals(52, Step2.getPriority('Z'));
	}
	
	@Test
	void shoudCalculateSumOfPriorityFromBackPacks() {
		String[] lines = Data.TEST.split("\n");
		assertEquals(70, Step2.calculateSumOfPrioritiesFromBackpack(lines));
	}
	

}
