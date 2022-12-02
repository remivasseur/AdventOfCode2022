package com.gitlab.doxterh.aoc2022.day02;

public class Step1 {
	// A,X for Rock
	// B,Y for Paper
	// C,Z for Scissors
	
	//		X	Y	Z
	// A	3	6	0
	// B	0	3	6
	// C	6	0	3
	
	public static int[][] POINTS = new int[256][];
	public static int[] SHAPE_POINTS = new int[256];
	static {
		POINTS['A'] = new int[256];
		POINTS['B'] = new int[256];
		POINTS['C'] = new int[256];
		POINTS['A']['X'] = 3;
		POINTS['A']['Y'] = 6;
		POINTS['A']['Z'] = 0;
		POINTS['B']['X'] = 0;
		POINTS['B']['Y'] = 3;
		POINTS['B']['Z'] = 6;
		POINTS['C']['X'] = 6;
		POINTS['C']['Y'] = 0;
		POINTS['C']['Z'] = 3;
		
		SHAPE_POINTS['X'] = 1;
		SHAPE_POINTS['Y'] = 2;
		SHAPE_POINTS['Z'] = 3;	
	}
	

	public static void main(String[] args) {

		System.out.println(calculateScore(Data.GAME.split("\n")));

	}


	public static int scoreRound(char them, char me) {
		return POINTS[them][me];
	}
	
	public static int scoreShapre(char me) {
		return SHAPE_POINTS[me];
	}


	public static int playRound(char them, char me) {
		// TODO Auto-generated method stub
		return scoreRound(them, me) + scoreShapre(me);
	}


	public static int calculateScore(String[] lines) {
		int score = 0;
		for (String line : lines) {
			String[] shape = line.split(" ");
			score += playRound(shape[0].charAt(0), shape[1].charAt(0));
		}
		return score;
	}

}
