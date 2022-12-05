package com.gitlab.doxterh.aoc2022.day03;


public class Step1 {

	public static void main(String[] args) {
		System.out.println(calculateSumOfPrioritiesFromBackpack(Data.GAME.split("\n")));
	}
	
	public static String getFirstCompartment(String rucksack) {
		int compartmentSize = rucksack.length()/2;

		return rucksack.substring(0, compartmentSize);
	}
	
	public static String getSecondCompartment(String rucksack) {
		int compartmentSize = rucksack.length()/2;
		return rucksack.substring(compartmentSize, rucksack.length());
	}

	public static char findItemInDouble(String rucksack) {
		char itemInDouble = 0;

		String firstCompartment = getFirstCompartment(rucksack);
		String secondCompartment = getSecondCompartment(rucksack);
		
		for (int i=0; i < firstCompartment.length(); i++) {
			String item = String.valueOf(firstCompartment.charAt(i));
			if (secondCompartment.contains(item)) {
				itemInDouble = firstCompartment.charAt(i);
			}
		}
		
		return itemInDouble;
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
		
		for (String line : lines) {
			char itemInDouble = findItemInDouble(line);
			sumOfPriorities += getPriority(itemInDouble);
		}
		
		return sumOfPriorities;
	}





}
