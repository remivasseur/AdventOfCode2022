package com.gitlab.doxterh.aoc2022.day13;

import com.gitlab.doxterh.aoc2022.utils.Logger;

public class Step1 {
	
	
	public static void main(String[] args) {
		Logger.ENABLE = false;
		int result = resolve(Data.GAME.split("\n"));
		
		System.out.println(result);
	}


	public static int resolve(String[] lines) {
		int sum = 0;
		for (int i=0; i < lines.length; i+=3) {
			Pair pair = new Pair(lines[i], lines[i+1]);
			int pairIndex = i/3 + 1;
			
			Logger.debug("== Pair " + pairIndex + " ==");
			
			if (pair.isInRightOrder()) {
				sum += pairIndex;
			}
		};
		
		return sum;
	}
	

}
