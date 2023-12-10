package com.gitlab.doxterh.aoc2022.day16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.gitlab.doxterh.aoc2022.day16.step1.Step1;

public class Step1Test {

	@Test
	void shouldResolve() {
		assertEquals(0, Step1.resolve(Data.TEST.split("\n")));

	}

}
