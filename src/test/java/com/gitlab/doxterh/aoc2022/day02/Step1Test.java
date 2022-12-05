package com.gitlab.doxterh.aoc2022.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Step1Test {

	@Test
	void shouldGetPointsForWinningRound() {
		assertEquals(6,Step1.scoreRound('A','Y'));
		assertEquals(6,Step1.scoreRound('B','Z'));
		assertEquals(6,Step1.scoreRound('C','X'));
	}
	
	@Test
	void shouldNotGetPointsForLoosingRound() {
		assertEquals(0,Step1.scoreRound('A','Z'));
		assertEquals(0,Step1.scoreRound('B','X'));
		assertEquals(0,Step1.scoreRound('C','Y'));
	}
	
	@Test
	void shouldNotGetPointsForLoosingDrawRound() {
		assertEquals(3,Step1.scoreRound('A','X'));
		assertEquals(3,Step1.scoreRound('B','Y'));
		assertEquals(3,Step1.scoreRound('C','Z'));
	}

	@Test
	void shouldGet1PointForShape() {
		assertEquals(1,Step1.scoreShapre('X'));
		assertEquals(2,Step1.scoreShapre('Y'));
		assertEquals(3,Step1.scoreShapre('Z'));
	}
	
	@Test
	void shouldGet8PointsWhenWiningWithPaper() {
		assertEquals(8, Step1.playRound('A','Y'));
	}
	
	@Test
	void shouldGet1PointWhenLoosingWithRock() {
		assertEquals(1, Step1.playRound('B','X'));
	}
	
	@Test
	void shouldGet6PointsWhenDrawWithScissors() {
		assertEquals(6, Step1.playRound('C','Z'));
	}
	
	@Test
	void shouldCalculateScoreForAllRounds() {
		String[] lines = Data.GAME_TEST.split("\n");
		
		assertEquals(15, Step1.calculateScore(lines));
	}
}
