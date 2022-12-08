package com.gitlab.doxterh.aoc2022.day08;

public class Step2 {

	public static void main(String[] args) {

		int[][] forest = populateForest(Data.GAME.split("\n"));
		
		
		for (int i = 0; i < forest.length; i++) {
			for (int j = 0; j < forest[0].length; j++) {
				System.out.print(forest[i][j]);
			}
			System.out.println();
		}
		


		int maxCoeff = getHighestScore(forest);
		
		System.out.println("\nCoeff: " + maxCoeff);

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

	
	private static int getHighestScore(int[][] forest) {
		
		int maxCoeff = 0;
		
		int visibleTrees = 0;
		
		for (int i = 0; i < forest.length; i++) {
			for (int j = 0; j < forest[0].length; j++) {
				
				//System.out.println("forest["+i+"]["+j+"]" + ": " + forest[i][j]);
				
				boolean isVisible = false;
				
				//Check from left
				int nbVisibleFromLeft = nbVisibleFromLeft(forest, i, j);
				
				//System.out.println("\tOn left : " + nbVisibleFromLeft + " trees");
				
				int nbVisibleFromFromRight =  nbVisibleFromRight(forest, i, j);
				
				//System.out.println("\tOn Right : " + nbVisibleFromFromRight + " trees");
				
				int nbVisibleFromTop = nbVisibleFromTop(forest, i, j);
				
				//System.out.println("\tOn Top : " + nbVisibleFromTop + " trees");
				
				int nbVisibleFromBottom = nbVisibleFromBottom(forest, i, j);
				
				//System.out.println("\tOn Bottom : " + nbVisibleFromBottom + " trees");
				
				
				int coeff = nbVisibleFromLeft * nbVisibleFromFromRight * nbVisibleFromTop * nbVisibleFromBottom;
				
				if (coeff > maxCoeff) {
					maxCoeff = coeff;
				}
				
				//System.out.println("forest["+i+"]["+j+"]" + ": " + forest[i][j] + "-> " + coeff);
				
			}
			//System.out.println();
		}

		return maxCoeff;
	}
	
	private static int nbVisibleFromBottom(int[][] forest, int line, int column) {
		
		int nb = 0;
		
		for (int i = line+1; i < forest.length; i++) {
			nb++;
			if (forest[i][column] >= forest[line][column]) {
				break;
			}
			
		}

		return nb;
	}



	private static int nbVisibleFromTop(int[][] forest, int line, int column) {
		int nb = 0;
		
		for (int i = line -1; i >= 0; i--) {
			nb++;
			if (forest[i][column] >= forest[line][column]) {
				break;
			}
		}

		return nb;
	}



	private static int nbVisibleFromRight(int[][] forest, int line, int column) {
		int nb = 0;
		for (int i = column +1; i < forest[0].length; i++) {
			nb++;
			if (forest[line][i] >= forest[line][column]) {
				break;
			}
		}

		return nb;
	}



	private static int nbVisibleFromLeft(int[][] forest, int line, int column) {
		int nb = 0;
		for (int i = column-1; i >= 0; i--) {
			nb++;
			if (forest[line][i] >= forest[line][column]) {
				break;
			}
		}

		return nb;
	}
	

}
