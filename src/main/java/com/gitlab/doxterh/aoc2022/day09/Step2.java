package com.gitlab.doxterh.aoc2022.day09;

import java.util.HashSet;
import java.util.Set;

public class Step2 {
	
	record Pos(int x, int y) {
		
	}
	
	public static int minLine = 0, maxLine = 0, minColumn = 0, maxColumn = 0;
	
	public static Set<Pos> visitedByTail = new HashSet<>();

	public static void main(String[] args) {

		String[] lines = Data.GAME.split("\n");

		char[][] grid = initGrid(lines);
		
		int[][] knotPositions = new int[10][2];
		
		for (int i=0; i < 10; i++) {
			knotPositions[0] = new int[] { 0, 0 };
		}

		int[] headPosition = knotPositions[0];
		int[] tailPosition = knotPositions[1];

		System.out.println("== Initial State ==\n");

		//print(grid, knotPositions);

		for (String line : lines) {

			//System.out.println("\n== " + line + " ==");

			String[] action = line.split(" ");
			char direction = action[0].charAt(0);
			int step = Integer.parseInt(action[1]);

			if (direction == 'R') {
				for (int i = 0; i < step; i++) {
					headPosition[1] += 1;

					moveTail(grid, knotPositions);

					//print(grid, knotPositions);
				}
			}
			if (direction == 'U') {
				for (int i = 0; i < step; i++) {
					headPosition[0] += 1;

					moveTail(grid, knotPositions);

					//print(grid, knotPositions);
				}
			}
			if (direction == 'D') {
				for (int i = 0; i < step; i++) {
					headPosition[0] -= 1;

					moveTail(grid, knotPositions);

					//print(grid, knotPositions);
				}
			}
			if (direction == 'L') {
				for (int i = 0; i < step; i++) {
					headPosition[1] -= 1;

					moveTail(grid, knotPositions);

					//print(grid, knotPositions);
				}
			}
		}
		
		//printVisited(grid);
		
		System.out.println("Total visited place : " + visitedByTail.size());

	}
	
	private static void moveTail(char[][] grid, int[][] knotPositions) {
		
		for (int i=1; i < 10; i++) {
			
		int[] previousKnot = knotPositions[i-1];
		int[] nextKnot =  knotPositions[i];
		
		int distance = distance(previousKnot, nextKnot);

		if (distance > 1) {

			if (nextKnot[1] < previousKnot[1]) {
				nextKnot[1]++;
			} else if (nextKnot[1] > previousKnot[1]) {
				nextKnot[1]--;
			}

			if (nextKnot[0] < previousKnot[0]) {
				nextKnot[0]++;
			} else if (nextKnot[0] > previousKnot[0]) {
				nextKnot[0]--;
			}

		}
		
		//System.out.println("[" + tailPosition[0] + "," + tailPosition[1]+"]");
		}

		visitedByTail.add(new Pos(knotPositions[9][0], knotPositions[9][1]));

	}

	private static void moveTail(char[][] grid, int[] headPosition, int[] tailPosition, int maxDistance) {
		
		int distance = distance(headPosition, tailPosition);

		if (distance > 1) {

			if (tailPosition[1] < headPosition[1]) {
				tailPosition[1]++;
			} else if (tailPosition[1] > headPosition[1]) {
				tailPosition[1]--;
			}

			if (tailPosition[0] < headPosition[0]) {
				tailPosition[0]++;
			} else if (tailPosition[0] > headPosition[0]) {
				tailPosition[0]--;
			}

		}
		
		System.out.println("[" + tailPosition[0] + "," + tailPosition[1]+"]");

		visitedByTail.add(new Pos(tailPosition[0], tailPosition[1]));

	}

	private static int distance(int[] headPosition, int[] tailPosition) {

		int distance = Math.max(Math.abs(tailPosition[0] - headPosition[0]),
				Math.abs(tailPosition[1] - headPosition[1]));

		return distance;
	}

	private static void print(char[][] grid, int[][] knotPosition) {
		System.out.println();
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = 0; j < grid[0].length; j++) {
				
				char toPrint = '.';
				
				for (int k = 0; k < 10; k++) {
					if (i == knotPosition[k][0] && j == knotPosition[k][1]) {
						
						if (k == 0 ) {
							toPrint = 'H';
						} else {
							toPrint = (char)(k + '0');
						}
						
						break;
					}
				}
				
				System.out.print(toPrint);

			}
			System.out.println();
		}

	}
	
	private static void printVisited(char[][] grid) {
		System.out.println();
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = 0; j < grid[0].length; j++) {
				
				if (visitedByTail.contains(new Pos(i,j))) {
					System.out.print('#');
				} else if (grid[i][j] == '\u0000') {
					System.out.print('.');
				}

			}
			System.out.println();
		}

	}

	public static char[][] initGrid(String[] lines) {
		int headLine = 0, headColumn = 0, tailLine = 0, tailColumn = 0;


		for (String line : lines) {

			String[] action = line.split(" ");
			char direction = action[0].charAt(0);
			int step = Integer.parseInt(action[1]);

			if (direction == 'R') {
				headColumn += step;

				if (headColumn > maxColumn) {
					maxColumn = headColumn;
				}

			}
			if (direction == 'U') {
				headLine += step;

				if (headLine > maxLine) {
					maxLine = headLine;
				}
			}
			if (direction == 'D') {
				headLine -= step;

				if (headLine < minLine) {
					minLine = headLine;
				}
			}
			if (direction == 'L') {
				headColumn -= step;

				if (headColumn < minColumn) {
					minColumn = headColumn;
				}
			}
		}

		int gridWidth = maxColumn - minColumn + 1;
		int gridHeight = maxLine - minLine + 1;

		System.out.println("Column : " + minColumn + " ->  " + maxColumn);
		System.out.println("Line : " + minLine + " ->  " + maxLine);

		System.out.println("" + gridWidth + " x " + gridHeight);
		System.out.println();

		return new char[gridHeight][gridWidth];
	}

}
