package com.gitlab.doxterh.aoc2022.day15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.gitlab.doxterh.aoc2022.day15.step1.Grid;
import com.gitlab.doxterh.aoc2022.day15.step1.Range;


public class Step1Test {
	@Test
	void correctSimpleRange() {
		List<Range> ranges= new ArrayList<>();
		ranges.add(new Range(1,5));
		ranges.add(new Range(2,4));
		
		List<Range> correctedRanges = Grid.correctRanges(ranges);
		assertEquals(1, correctedRanges.size());
		assertEquals(new Range(1,5), correctedRanges.get(0));
	}
	
	@Test
	void correctSimpleRange2() {
		List<Range> ranges= new ArrayList<>();
		ranges.add(new Range(2,4));
		ranges.add(new Range(1,10));
		ranges.add(new Range(6,9));
		
		List<Range> correctedRanges = Grid.correctRanges(ranges);
		assertEquals(1, correctedRanges.size());
		assertEquals(new Range(1,10), correctedRanges.get(0));
	}
	
	@Test
	void disjointRangeShouldBePreserves() {
		List<Range> ranges= new ArrayList<>();
		ranges.add(new Range(2,4));
		ranges.add(new Range(6,9));
		
		List<Range> correctedRanges = Grid.correctRanges(ranges);
		assertEquals(2, correctedRanges.size());
		assertEquals(new Range(2,4), correctedRanges.get(0));
		assertEquals(new Range(6,9), correctedRanges.get(1));
	}
	
	@Test
	void shouldjoinRanges() {
		List<Range> ranges= new ArrayList<>();
		ranges.add(new Range(2,4));
		ranges.add(new Range(3,9));
		
		List<Range> correctedRanges = Grid.correctRanges(ranges);
		assertEquals(1, correctedRanges.size());
		assertEquals(new Range(2,9), correctedRanges.get(0));
	}
	
	@Test
	void shouldjoinRanges2() {
		List<Range> ranges= new ArrayList<>();
		ranges.add(new Range(-1,2));
		ranges.add(new Range(3,9));
		ranges.add(new Range(2,4));
		
		
		List<Range> correctedRanges = Grid.correctRanges(ranges);
		assertEquals(1, correctedRanges.size());
		assertEquals(new Range(-1,9), correctedRanges.get(0));
	}
	
	@Test
	void moreComplex() {
		List<Range> ranges= new ArrayList<>();
		ranges.add(new Range(-1,2));
		ranges.add(new Range(18,30));
		ranges.add(new Range(3,9));
		ranges.add(new Range(2,4));
		ranges.add(new Range(12,20));
		
		
		List<Range> correctedRanges = Grid.correctRanges(ranges);
		assertEquals(2, correctedRanges.size());
		assertEquals(new Range(-1,9), correctedRanges.get(1));
		assertEquals(new Range(12,30), correctedRanges.get(0));
	}
	
}
