package com.gitlab.doxterh.aoc2022.day13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class Step2Test {
	@Test
	void test() {
		int result = Step2.resolve(Data.TEST.split("\n"));
		
		assertEquals(140, result);
	}
	
}
