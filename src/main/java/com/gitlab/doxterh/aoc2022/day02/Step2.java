package com.gitlab.doxterh.aoc2022.day02;

public class Step2 {
	// A,X for Rock
	// B,Y for Paper
	// C,Z for Scissors
	
	//		X	Y	Z
	// A	3	6	0
	// B	0	3	6
	// C	6	0	3
	
	public static Intent[][] POINTS = new Intent[3][];
	public static Intent[] SHAPE_POINTS = new Intent[3];
	static {
		POINTS[0] = new Intent[3];
		POINTS[1] = new Intent[3];
		POINTS[2] = new Intent[3];
		POINTS[0][0] = Intent.DRAW;
		POINTS[0][1] = Intent.WIN;
		POINTS[0][2] = Intent.LOOSE;
		POINTS[1][0] = Intent.LOOSE;
		POINTS[1][1] = Intent.DRAW;
		POINTS[1][2] = Intent.WIN;
		POINTS[2][0] = Intent.WIN;
		POINTS[2][1] = Intent.LOOSE;
		POINTS[2][2] = Intent.DRAW;
	}
	

	public static void main(String[] args) {

		System.out.println(calculateScore(Data.GAME.split("\n")));

	}


	public static int scoreRound(Shape hisShape, Shape myShape) {
		return POINTS[hisShape.id()][myShape.id()].score();
	}
	
	public static int scoreShape(Shape shape) {
		return shape.score();
	}


	public static int playRound(char him, char intent) {
		
		Shape hisShape = getHisShape(him);
		Intent myIntent = getMyIntent(intent);
		Shape myShape = calculateWhichShapeToPlay(hisShape, myIntent);

		return scoreRound(hisShape, myShape) + scoreShape(myShape);
	}


	public static int calculateScore(String[] lines) {
		int score = 0;
		for (String line : lines) {
			String[] shape = line.split(" ");
			score += playRound(shape[0].charAt(0), shape[1].charAt(0));
		}
		return score;
	}


	public static Shape getHisShape(char code) {
		return Shape.fromCode(code);
	}

	public static Intent getMyIntent(char code) {
		return Intent.fromCode(code);
	}

	public static Shape calculateWhichShapeToPlay(Shape hisShape, Intent myIntent) {

		Shape myShape = null;
		
		for (int i=0; i < POINTS[hisShape.id()].length; i++) {
			Intent intent = POINTS[hisShape.id()][i];
			
			if (intent == myIntent) {
				myShape = Shape.fromId(i);
			}
		}
		
		return myShape;
	}

}
