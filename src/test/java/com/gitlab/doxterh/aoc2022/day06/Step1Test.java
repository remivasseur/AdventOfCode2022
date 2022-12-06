package com.gitlab.doxterh.aoc2022.day06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Test;

class Step1Test {

	@Test
	void shouldGetMarker1() {
		
		assertEquals(7,Step1.getMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
	}
	
	@Test
	void shouldGetMarker2() {
		
		assertEquals(5,Step1.getMarker("bvwbjplbgvbhsrlpgdmjqwftvncz"));
	}
	
	@Test
	void shouldGetMarker3() {
		
		assertEquals(6,Step1.getMarker("nppdvjthqldpwncqszvftbrmjlhg"));
	}
	
	@Test
	void shouldGetMarker4() {
		
		assertEquals(10,Step1.getMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));
	}
	
	@Test
	void shouldGetMarker5() {
		
		assertEquals(11,Step1.getMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));
	}
}
