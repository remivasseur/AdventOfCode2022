package com.gitlab.doxterh.aoc2022.day08;

public class Step1 {

	public static void main(String[] args) {

		int[][] forest = populateForest(Data.GAME.split("\n"));
		
		
		for (int i = 0; i < forest.length; i++) {
			for (int j = 0; j < forest[0].length; j++) {
				System.out.print(forest[i][j]);
			}
			System.out.println();
		}
		
		
		int countVisibleTreeOnEdge = countVisibleTreeOnEdge(forest);
		
		System.out.println("\nTrees visible on edge: " + countVisibleTreeOnEdge);

		int nbTreeVisibleInside = countTreesVisibleInside(forest);
		
		System.out.println("\nTrees visible inside: " + nbTreeVisibleInside);
		
		System.out.println("\nTotal trees visible : " + (countVisibleTreeOnEdge + nbTreeVisibleInside));
	}



	private static int[][] populateForest(String[] lines) {
		int width = lines[0].length();
		int height = lines.length;

		int[][] forest = new int[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				forest[i][j] = lines[i].charAt(j) - '0';
			}
		}
		
		return forest;
	}
	
	private static int countVisibleTreeOnEdge(int[][] forest) {
		int width = forest[0].length;
		int height = forest.length;
		
		return 2* width + (height -2) * 2;

	}
	
	private static int countTreesVisibleInside(int[][] forest) {
		
		int visibleTrees = 0;
		
		for (int i = 1; i < forest.length -1; i++) {
			for (int j = 1; j < forest[0].length -1; j++) {
				
				boolean isVisible = false;
				
				//Check from left
				isVisible = isVisible || isVisibleFromLeft(forest, i, j);
				
				isVisible = isVisible || isVisibleFromRight(forest, i, j);
				
				isVisible = isVisible || isVisibleFromTop(forest, i, j);
				
				isVisible = isVisible || isVisibleFromBottom(forest, i, j);
				
				if (isVisible) {
					
					visibleTrees ++;
					System.out.println("forest["+i+"]["+j+"]" + ": " + forest[i][j] + " is visible");
				} else {
					System.out.println("forest["+i+"]["+j+"]" + ": " + forest[i][j] + " is not visible");
				}
				
				
			}
			System.out.println();
		}

		return visibleTrees;
	}
	
	private static boolean isVisibleFromBottom(int[][] forest, int line, int column) {
		for (int i = line+1; i < forest.length; i++) {
			
			if (forest[i][column] >= forest[line][column]) {
				return false;
			}
		}

		return true;
	}



	private static boolean isVisibleFromTop(int[][] forest, int line, int column) {
		for (int i = 0; i < line; i++) {
			
			if (forest[i][column] >= forest[line][column]) {
				return false;
			}
		}

		return true;
	}



	private static boolean isVisibleFromRight(int[][] forest, int line, int column) {
		for (int i = column +1; i < forest[0].length; i++) {
			
			if (forest[line][i] >= forest[line][column]) {
				return false;
			}
		}

		return true;
	}



	private static boolean isVisibleFromLeft(int[][] forest, int line, int column) {
		//System.out.println("forest["+line+"]["+column+"]" + ": " + forest[line][column]);
		for (int i = 0; i < column; i++) {
			
			if (forest[line][i] >= forest[line][column]) {
				return false;
			}
		}

		return true;
	}
	

}
