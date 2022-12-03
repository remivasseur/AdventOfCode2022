package com.gitlab.doxterh.aoc2022.day03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Step2 {

	public static void main(String[] args) {
		System.out.println(calculateSumOfPrioritiesFromBackpack(Data.GAME.split("\n")));
	}
	

	public static int getPriority(char c) {
		if (Character.isLowerCase(c)) {
			return c - 96;
		} else {
			return c - 38;
		}
		
	}


	public static int calculateSumOfPrioritiesFromBackpack(String[] lines) {

		int sumOfPriorities = 0;
		
		for (int i=0; i < lines.length; i+=3) {
			char badge = findGroupBadge(lines[i], lines[i+1], lines[i+2]);
			sumOfPriorities += getPriority(badge);
		}
		
		return sumOfPriorities;
	}

	public static char findGroupBadge(String... group) {
		Set<Character> setOfItem = new HashSet<>();

		for (String backPack : group) {
			if (setOfItem.isEmpty()) {
				for(int i=0; i < backPack.length(); i++) {
					setOfItem.add(backPack.charAt(i));
				}
			} else {
				for (Iterator<Character> iterator = setOfItem.iterator(); iterator.hasNext();) {
				    char itemToCheckIfDuplicate = iterator.next();
				    //System.out.println("Check if " + itemToCheckIfDuplicate + " is in " +  backPack);
				    
				    if (backPack.indexOf(itemToCheckIfDuplicate) == -1) {
				    	iterator.remove();
				    }
				}
			}
			
		}
		
		if (setOfItem.size() == 1) {
			return setOfItem.iterator().next();
		} else {
			throw new RuntimeException("Plusieurs badges trouvés...");
		}
	}





}
