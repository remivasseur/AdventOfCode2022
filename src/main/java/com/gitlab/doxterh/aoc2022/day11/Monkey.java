package com.gitlab.doxterh.aoc2022.day11;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Monkey {
	public int id;
	public List<Item> items = new ArrayList<>();
	public Operation operation;
	public int divisibleBy;
	public int monkeyIfTrue;
	public int monkeyIfFalse;
	
	public int inspectionCount = 0;;

	public int getInspectionCount() {
		return inspectionCount;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Monkey ").append(id).append(":\n");
		sb.append("  Starting items: ");
		
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			if (i > 0 ) {
				sb.append(", ");
			}
			sb.append(item);
		}
		
		sb.append("\n  Operation: ").append(operation);
		sb.append("\n  Test: divisible by ").append(divisibleBy);
		
		sb.append("\n    If true: throw to monkey ").append(monkeyIfTrue);
		sb.append("\n    If false: throw to monkey ").append(monkeyIfFalse);

		return sb.toString();
	}

	public void playTurn() {
		StringBuilder sb = new StringBuilder();
		sb.append("Monkey ").append(id).append(":\n");
		
		//System.out.println("-> Monkey " + id + " -> " + items.size() + " items");
		
		for (Item item : items) {
			
			//System.out.println("  -> item : " + item.getWorry());
			
			inspectionCount++;
			sb.append("  Monkey inspects an item with a worry level of ").append(item).append("\n");

			BigInteger worry = operation.execute(item.getWorry());
			
			item.setWorry(worry);
			
			final int toMonkey;

			if (BigInteger.ZERO.equals(item.getWorry().remainder(BigInteger.valueOf(divisibleBy)))) {
			//if (operation.divisibleBy(previousWorry, divisibleBy)) {
				sb.append("    Current worry level is divisible by ").append(divisibleBy).append(".\n");
				toMonkey = monkeyIfTrue;
				
			} else {
				sb.append("    Current worry level is not divisible by ").append(divisibleBy).append(".\n");
				toMonkey = monkeyIfFalse;
			}

			sb.append("    Item with worry level ").append(item.getWorry()).append(" is thrown to monkey ").append(toMonkey);
			
			Step1.monkeys.get(toMonkey).items.add(item);
			
		}
		
		items.clear();

		//System.out.println(sb.toString());
		
	}
	


}
