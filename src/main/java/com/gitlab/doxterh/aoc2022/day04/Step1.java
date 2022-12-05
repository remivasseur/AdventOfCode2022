package com.gitlab.doxterh.aoc2022.day04;

public class Step1 {

	public static void main(String[] args) {
		
		System.out.println(getTotalOfFullyContainedPairs(Data.GAME.split("\n")));
	}

	public static Section getSection(String codeSection) {
		String[] endpoints = codeSection.split("-");
		return new Section(Integer.valueOf(endpoints[0]), Integer.valueOf(endpoints[1]));
	}

	public static Section[] getAssignmentPair(String codePair) {

		String[] pairs = codePair.split(",");
		Section[] sections = new Section[2];
		sections[0] = getSection(pairs[0]);
		sections[1] = getSection(pairs[1]);
		
		return sections;
	}

	public static boolean isPairContainedByTheOther(String line) {
		Section[] sections = getAssignmentPair(line);

		boolean containsOrIsContainedBy = sections[0].overlapWith(sections[1]);
		
		//System.out.println(sections[0] + " " + sections[1] + " -> " + containsOrIsContainedBy);
		
		
		return containsOrIsContainedBy;
	}

	public static int getTotalOfFullyContainedPairs(String[] lines) {

		int count = 0;
		
		for (String line : lines) {
			if (isPairContainedByTheOther(line)) {
				count++;
			}
		}
		return count;
	}
	
	



}
