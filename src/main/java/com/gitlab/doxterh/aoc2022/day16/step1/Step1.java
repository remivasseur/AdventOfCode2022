package com.gitlab.doxterh.aoc2022.day16.step1;

import java.util.ArrayDeque;
import java.util.Queue;

import com.gitlab.doxterh.aoc2022.day16.Data;

public class Step1 {

	public static void main(String[] args) {
		int sum = resolve(Data.GAME.split("\n"));
		System.out.println(sum);
	}

	public static int resolve(String[] lines) {
		
		
		
		Parser.parse(lines);

		Graph.calculateDistanceBetweenEachPressureNode();
		
		Queue<State> states = new ArrayDeque<>();
		
		
		Graph.forEachPressureNode(node -> {
			State state = new State(Graph.getNode("AA"));
			state.openValve(node);
			states.add(state);
		});


		int max = 0;
		State bestState = null;
		
		while(!states.isEmpty()) {
			State currentState = states.remove();

			for(Node valve : currentState.getRemainingClosedValves())
			{
				State nextState = new State(currentState);
				boolean canOpenValveInTime = nextState.openValve(valve);
				if (canOpenValveInTime) {
					states.add(nextState);
				} else {
					if(currentState.totalPressureReleased() > max) {
						max = currentState.totalPressureReleased();
						bestState = currentState;
					}
				}
				
			}
			
			if (currentState.getRemainingClosedValves().isEmpty()) {
				if(currentState.totalPressureReleased() > max) {
					max = currentState.totalPressureReleased();
					bestState = currentState;
				}
				
			}
		}
		
		System.out.println(bestState);
		

		return max;
	}
	


}
