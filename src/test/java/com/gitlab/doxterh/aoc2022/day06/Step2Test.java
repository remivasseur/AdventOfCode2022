package com.gitlab.doxterh.aoc2022.day06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Test;

class Step2Test {

	@Test
	void shouldGetMarker1() {
		
		assertEquals(19,Step2.getMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb"));
	}
	
	@Test
	void shouldGetMarker2() {
		
		assertEquals(23,Step2.getMarker("bvwbjplbgvbhsrlpgdmjqwftvncz"));
	}
	
	@Test
	void shouldGetMarker3() {
		
		assertEquals(23,Step2.getMarker("nppdvjthqldpwncqszvftbrmjlhg"));
	}
	
	@Test
	void shouldGetMarker4() {
		
		assertEquals(29,Step2.getMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"));
	}
	
	@Test
	void shouldGetMarker5() {
		
		assertEquals(26,Step2.getMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"));
	}
}
