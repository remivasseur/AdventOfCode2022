package com.gitlab.doxterh.aoc2022.day05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


public class Step1 {

	public static void main(String[] args) {
		
		System.out.println(getTopElementOfEachStack(Data.GAME.split("\n")));
	}



	public static Integer getIndexLineNumber(String[] lines) {

		for (int i=0; i< lines.length; i++) {

			if (lines[i].trim().isEmpty()) {
				return i-1;
			}
		}
		return -1;
	}



	public static Map<Integer, Integer> getMappedColumnIndex(String[] lines) {
		int indexLineNumber = getIndexLineNumber(lines);
		
		Map<Integer, Integer> columnsIndex = new HashMap<>();
		
		String indexLine = lines[indexLineNumber];
		
		for (int i = 0; i < indexLine.length(); i++) {
			char character = indexLine.charAt(i);
			
			if (Character.isDigit(character)) {

				int columnId = character - '0';
				
				columnsIndex.put(columnId, i);
			}
		}
		
		return columnsIndex;
	}



	public static Stack<Character>[] populateStack(String[] lines) {

		Map<Integer, Integer> columnsIndex = getMappedColumnIndex(lines);
		int nbStacks = columnsIndex.size();
		

		Stack<Character>[] stacks = new Stack[nbStacks];
		for (int i=0; i < nbStacks; i++) {
			stacks[i] = new Stack<>();
		}
		
		int indexLineNumber = getIndexLineNumber(lines);
		
		for (int i=indexLineNumber-1; i >=0; i--) {
			for (int j=1; j <= nbStacks; j++) {
				int columnIndex = columnsIndex.get(j);
				
				if(columnIndex < lines[i].length()) {
					char item = lines[i].charAt(columnIndex);
					
					if (Character.isLetter(item)) {
						stacks[j-1].push(item);
					}
				}
				
			}
		}
		
		
		return stacks;
	}



	public static int[] parseAction(String action) {
		int[] values = new int[3];
		try (Scanner s = new Scanner(action)) {
			s.useDelimiter("[^\\d]+");
			int i=0;
			while (s.hasNextInt()) {
				values[i++] = s.nextInt();
			}
		}
		return values;
	}



	public static void applyProcedureStep(Stack<Character>[] stacks, String action) {
		int[] values = parseAction(action);
		
		int quantity = values[0];
		int from = values[1];
		int to = values[2];
		
		for (int i=0; i < quantity; i++) {
			stacks[to-1].push(stacks[from-1].pop());
		}
		
	}



	public static Stack<Character>[] applyProcedure(String[] lines) {

		Stack<Character>[] stacks = populateStack(lines);
		
		int indexLineNumber = getIndexLineNumber(lines);
		
		for (int i=indexLineNumber+2; i < lines.length; i++) {
			applyProcedureStep(stacks, lines[i]);
		}
		
		return stacks;
	}



	public static String getTopElementOfEachStack(String[] lines) {
		Stack<Character>[] stacks = applyProcedure(lines);
		
		String result = "";
		
		for (int i=0; i< stacks.length; i++) {
			result+= stacks[i].pop();
		}
		
		return result;
	}

	
	
	



}
