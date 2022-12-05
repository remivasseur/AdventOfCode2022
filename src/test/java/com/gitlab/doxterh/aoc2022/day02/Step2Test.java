package com.gitlab.doxterh.aoc2022.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Step2Test {
	
	// X : loose
	// Y : draw
	// Z : win

	@Test
	void shouldGetPointsForWinningRound() {
		assertEquals(6,Step2.scoreRound(Shape.ROCK,Shape.PAPER));
		assertEquals(6,Step2.scoreRound(Shape.PAPER,Shape.SCISSORS));
		assertEquals(6,Step2.scoreRound(Shape.SCISSORS,Shape.ROCK));
	}
	
	@Test
	void shouldNotGetPointsForLoosingRound() {
		assertEquals(0,Step2.scoreRound(Shape.ROCK,Shape.SCISSORS));
		assertEquals(0,Step2.scoreRound(Shape.PAPER,Shape.ROCK));
		assertEquals(0,Step2.scoreRound(Shape.SCISSORS,Shape.PAPER));
	}
	
	@Test
	void shouldNotGetPointsForLoosingDrawRound() {
		assertEquals(3,Step2.scoreRound(Shape.ROCK,Shape.ROCK));
		assertEquals(3,Step2.scoreRound(Shape.PAPER,Shape.PAPER));
		assertEquals(3,Step2.scoreRound(Shape.SCISSORS,Shape.SCISSORS));
	}
	
	@Test
	void shoudGetHisShape() {
		assertEquals(Shape.ROCK, Step2.getHisShape('A'));
		assertEquals(Shape.PAPER, Step2.getHisShape('B'));
		assertEquals(Shape.SCISSORS, Step2.getHisShape('C'));
	}
	
	@Test
	void shoudGetMyIntent() {
		assertEquals(Intent.LOOSE, Step2.getMyIntent('X'));
		assertEquals(Intent.DRAW, Step2.getMyIntent('Y'));
		assertEquals(Intent.WIN, Step2.getMyIntent('Z'));
	}
	
	@Test
	void shouldPlayRockWhenNeedToDrawAndOtherPlaysRock() {
		assertEquals(Shape.ROCK, Step2.calculateWhichShapeToPlay(Shape.ROCK,Intent.DRAW));
	}
	
	@Test
	void shouldPlayRockWhenNeedToLoseAndOtherPlaysPaper() {
		assertEquals(Shape.ROCK, Step2.calculateWhichShapeToPlay(Shape.PAPER,Intent.LOOSE));
	}
	
	@Test
	void shouldPlayRockWhenNeedToWinAndOtherPlaysScissors() {
		assertEquals(Shape.ROCK, Step2.calculateWhichShapeToPlay(Shape.SCISSORS,Intent.WIN));
	}



	@Test
	void shouldGet1PointForShape() {
		assertEquals(1,Step2.scoreShape(Shape.ROCK));
		assertEquals(2,Step2.scoreShape(Shape.PAPER));
		assertEquals(3,Step2.scoreShape(Shape.SCISSORS));
	}
	
	@Test
	void shouldGet4PointsWhenDrawWhenOtherPlayRock() {
		assertEquals(4, Step2.playRound('A','Y'));
	}
	
	@Test
	void shouldGet1PointWhenLoosingWhenOtherPlayPaper() {
		assertEquals(1, Step2.playRound('B','X'));
	}
	
	@Test
	void shouldGet6PointsWhenWinningWhenOtherPlayScissors() {
		assertEquals(7, Step2.playRound('C','Z'));
	}
	
	@Test
	void shouldCalculateScoreForAllRounds() {
		String[] lines = Data.GAME_TEST.split("\n");
		
		assertEquals(12, Step2.calculateScore(lines));
	}
}
