package com.gitlab.doxterh.aoc2022.day06;

import java.util.HashSet;
import java.util.Set;


public class Step1 {

	public static void main(String[] args) {
		
		System.out.println(getMarker(Data.GAME));
	}

	public static int getMarker(String string) {
		
		Set<Character> setOfChar = new HashSet<>();
		for (int i=3; i < string.length(); i++) {
			//System.out.println((i+1) + " ->" + string.charAt(i-3) + string.charAt(i-2) + string.charAt(i-1) + string.charAt(i));
			setOfChar.clear();
			for (int j=i-3; j <= i; j++) {
				//System.out.println("\t" + string.charAt(j));
				setOfChar.add(string.charAt(j));
			}
			
			if (setOfChar.size() >=4) {
				//System.out.println((i+1) + " ->" + setOfChar.size());
				return i+1;
			}
			
		}
		return -1;
	}

}
