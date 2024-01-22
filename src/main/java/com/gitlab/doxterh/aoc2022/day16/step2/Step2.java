package com.gitlab.doxterh.aoc2022.day16.step2;

import java.util.ArrayDeque;
import java.util.Queue;

import com.gitlab.doxterh.aoc2022.day16.Data;

public class Step2 {

	public static void main(String[] args) {
		int sum = resolve(Data.TEST.split("\n"));
		System.out.println(sum);
	}

	public static int resolve(String[] lines) {
		Parser.parse(lines);

		Graph.calculateDistanceBetweenEachPressureNode();
		
		Queue<State> states = new ArrayDeque<>();
		
		Graph.forEachPressureNode(node -> {
			State state = new State(Graph.getNode("AA"));
			state.elfeOpenValve(node);
			
			
			
			states.add(state);
		});
		


		int max = 0;
		State bestState = null;
		
		while(!states.isEmpty()) {
			State currentState = states.remove();


		}
		
		System.out.println(bestState);
		

		return max;
	}
	


}
