package com.gitlab.doxterh.aoc2022.day10;

import java.util.ArrayList;
import java.util.List;

public class Step1 {

	public static int x = 1;
	public static int cycle = 1;

	public static List<Integer> valuesOfXByCycles = new ArrayList<>();

	public static void main(String[] args) {

		String[] lines = Data.GAME.split("\n");

		valuesOfXByCycles.add(x);

		for (String line : lines) {
			String[] instructions = line.split(" ");

			if ("noop".equals(instructions[0])) {

				for (int i = 0; i < 1; i++) {
					//System.out.println("Cycle " + cycle + ": \n\tNoop\n\tx=" + x);
					cycle++;

					valuesOfXByCycles.add(x);
				}
				//System.out.println("\t->x=" + x);
			} else if ("addx".equals(instructions[0])) {
				int value = Integer.parseInt(instructions[1]);

				for (int i = 0; i < 2; i++) {
					//System.out.println("Cycle " + cycle + ": \n\tAddx " + value + "\n\tx=" + x);
					cycle++;

					valuesOfXByCycles.add(x);
				}
				x += value;

				//System.out.println("\t->x=" + x);
			}
		}

		valuesOfXByCycles.add(x);
		
		int sumOfSignalStrengh = 0;

		for (int i = 0; i < valuesOfXByCycles.size(); i++) {

			int value = valuesOfXByCycles.get(i);

			if ((i - 20) % 40 == 0) {
				System.out.println("Cycle " + i + ":");
				System.out.println("\t -> x = " + value);
				int signalStrenth = i * value;
				System.out.println("\t Signal strength : " + i + " x " + value + " = " + signalStrenth);
				
				sumOfSignalStrengh += signalStrenth;
			}
		}
		
		System.out.println("Total signal strength : " + sumOfSignalStrengh);

	}
	
}
