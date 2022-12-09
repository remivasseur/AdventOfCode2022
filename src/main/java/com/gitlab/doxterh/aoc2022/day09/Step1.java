package com.gitlab.doxterh.aoc2022.day09;

import java.util.HashSet;
import java.util.Set;

public class Step1 {
	
	record Pos(int x, int y) {
		
	}
	
	public static int minLine = 0, maxLine = 0, minColumn = 0, maxColumn = 0;
	
	public static Set<Pos> visitedByTail = new HashSet<>();

	public static void main(String[] args) {

		String[] lines = Data.GAME.split("\n");

		char[][] grid = initGrid(lines);

		int[] headPosition = { 0, 0 };
		int[] tailPosition = { 0, 0 };

		System.out.println("== Initial State ==\n");

		print(grid, headPosition, tailPosition);

		for (String line : lines) {

			//System.out.println("\n== " + line + " ==");

			String[] action = line.split(" ");
			char direction = action[0].charAt(0);
			int step = Integer.parseInt(action[1]);

			if (direction == 'R') {
				for (int i = 0; i < step; i++) {
					headPosition[1] += 1;

					moveTail(grid, headPosition, tailPosition, 1);

					//print(grid, headPosition, tailPosition);
				}
			}
			if (direction == 'U') {
				for (int i = 0; i < step; i++) {
					headPosition[0] += 1;

					moveTail(grid,headPosition, tailPosition, 1);

					//print(grid, headPosition, tailPosition);
				}
			}
			if (direction == 'D') {
				for (int i = 0; i < step; i++) {
					headPosition[0] -= 1;

					moveTail(grid,headPosition, tailPosition, 1);

					//print(grid, headPosition, tailPosition);
				}
			}
			if (direction == 'L') {
				for (int i = 0; i < step; i++) {
					headPosition[1] -= 1;

					moveTail(grid,headPosition, tailPosition, 1);

					//print(grid, headPosition, tailPosition);
				}
			}
		}
		
		printVisited(grid);
		
		System.out.println("Total visited place : " + visitedByTail.size());

	}

	private static void moveTail(char[][] grid, int[] headPosition, int[] tailPosition, int maxDistance) {
		int distance = distance(headPosition, tailPosition);
		// System.out.println("Distance entre H["+ headPosition[0]+ ","
		// +headPosition[1]+ "] et T["+ tailPosition[0]+ "," +tailPosition[1]+ "]: " +
		// distance);

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

	private static void print(char[][] grid, int[] headPosition, int[] tailPosition) {
		System.out.println();
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = 0; j < grid[0].length; j++) {

				if (i == headPosition[0] && j == headPosition[1]) {
					System.out.print('H');
				} else if (i == tailPosition[0] && j == tailPosition[1]) {
					System.out.print('T');
				} else if (grid[i][j] == '\u0000') {
					System.out.print('.');
				}

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
