package com.gitlab.doxterh.aoc2022.day13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class Step1Test {
	@Test
	void shouldReturn13ForTestData() {
		
		assertEquals(13,Step1.resolve(Data.TEST.split("\n")));
	}
	
}
