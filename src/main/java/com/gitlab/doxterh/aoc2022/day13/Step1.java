package com.gitlab.doxterh.aoc2022.day13;

public class Step1 {

	public static void main(String[] args) {
		resolve(Data.GAME.split("\n"));
	}


	public static int resolve(String[] lines) {

		for (int i=0; i < lines.length; i+=3) {
			Pair pair = new Pair(lines[i], lines[i+1]);
			
			System.out.println("== Pair " + (i/3 + 1) + " ==");
			pair.compare();
		};
		
		return -1;
	}
	

}
