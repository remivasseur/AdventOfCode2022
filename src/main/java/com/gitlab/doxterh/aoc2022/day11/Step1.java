package com.gitlab.doxterh.aoc2022.day11;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Step1 {

	public static List<Monkey> monkeys;

	public static void main(String[] args) {
		
		String[] lines = Data.TEST.split("\n");

		monkeys = loadMonkeys(lines);

		// monkeys.forEach(System.out::println);

		int round = 0;

		while (round < 10000) {
			round++;
			long start = System.currentTimeMillis();

			for (Monkey monkey : monkeys) {
				monkey.playTurn();
			}
			
			if (round == 1 || round == 20 || round % 1000 == 0) {
				System.out
						.println("\nAfter round " + round + ", the monkeys are holding items with these worry levels:");

				
				for (Monkey monkey : monkeys) {
					System.out
							.println("Monkey " + monkey.id + " inspected items " + monkey.inspectionCount + " times.");
					
					
				}

			}
			
			long finish = System.currentTimeMillis();
			long timeElapsed = finish - start;

			System.out.println("round " + round + " -> " + timeElapsed + " ms");

		}
		/*
		 * System.out.println();
		 * 
		 * monkeys.sort(Comparator.comparing(Monkey::getInspectionCount));
		 * Collections.reverse(monkeys);
		 * 
		 * 
		 * 
		 * int monkeyBusiness = monkeys.get(0).getInspectionCount() *
		 * monkeys.get(1).getInspectionCount();
		 * 
		 * System.out.println("\nMonkey Business :" + monkeyBusiness);
		 */
	}

	private static List<Monkey> loadMonkeys(String[] lines) {
		List<Monkey> monkeys = new ArrayList<>();

		for (int i = 0; i < lines.length; i = i + 7) {

			Monkey monkey = new Monkey();
			monkey.id = extractId(lines[i]);
			monkey.items = extractItems(lines[i + 1]);
			monkey.operation = extractOperation(lines[i + 2]);
			monkey.divisibleBy = extractDivisibleBy(lines[i + 3]);
			monkey.monkeyIfTrue = extractThrowToMonkey(lines[i + 4]);
			monkey.monkeyIfFalse = extractThrowToMonkey(lines[i + 5]);

			monkeys.add(monkey);

		}

		return monkeys;
	}

	private static int extractId(String line) {
		String[] elem = line.split(" ");
		String id = elem[1].substring(0, elem[1].length() - 1);

		return Integer.parseInt(id);
	}

	private static List<Item> extractItems(String line) {
		List<Item> list = new ArrayList<>();
		String[] elem = line.split(":");
		String[] items = elem[1].split(",");

		for (String item : items) {
			list.add(new Item(new BigInteger(item.trim())));
		}

		return list;
	}

	private static Operation extractOperation(String line) {

		String[] equations = line.split(" = ");
		String[] operands = equations[1].split(" ");

		Operation operation = new Operation(operands[0], operands[2], operands[1].charAt(0));

		return operation;
	}

	private static int extractDivisibleBy(String line) {

		String[] words = line.split(" by ");

		return Integer.parseInt(words[1]);
	}

	private static int extractThrowToMonkey(String line) {

		String[] words = line.split("monkey ");

		return Integer.parseInt(words[1]);
	}

}
