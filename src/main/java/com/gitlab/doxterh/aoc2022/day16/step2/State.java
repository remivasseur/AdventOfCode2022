package com.gitlab.doxterh.aoc2022.day16.step2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class State {
	private List<OpenedValve> openedValves = new ArrayList<>();
	private Set<String> openedValvesSet = new HashSet<>();
	private int[] pressureReleased = new int[26];
	private Node elfeCurrentNode;
	private Node elephantCurrentNode;
	public int elapsedTime = 0;
	

	public State(Node currentNode) {
		this.elfeCurrentNode = currentNode;
		for (int i=0; i < 26;i++) {
			pressureReleased[i]=0;
		}
	}

	public State(State previousState) {
		this(previousState.elfeCurrentNode);
		previousState.openedValves.forEach(node -> {
			openedValvesSet.add(node.valve().getId());
			openedValves.add(node);
		});
		this.elapsedTime = previousState.elapsedTime;
		for (int i=0; i < 26;i++) {
			pressureReleased[i]=previousState.pressureReleased[i];
		}
	}

	public List<Node> getRemainingClosedValves() {
		List<Node> remainingsNode = new ArrayList<>();

		Graph.forEachPressureNode(node -> {
			if (!openedValvesSet.contains(node.getId())) {
				remainingsNode.add(node);
			}
		});

		return remainingsNode;
	}


	public boolean elfeOpenValve(Node node) {
		int distance = Graph.getDistance(this.elfeCurrentNode, node);
		int previousElapsedTime = this.elapsedTime;
		
		elapsedTime = this.elapsedTime + distance + 1;
		if (elapsedTime > 26) {
			return false;
		} else {
			for (int i=previousElapsedTime+1; i < 26; i++) {
				pressureReleased[i] = pressureReleased[previousElapsedTime];
				
				if (i >= elapsedTime) {
					pressureReleased[i] += node.getFlowRate();
				}
			}
			
		}
		
		openedValvesSet.add(node.getId());
		openedValves.add(new OpenedValve(node, elapsedTime));
		
		this.elfeCurrentNode = node;
		return true;
	}
	
	public int totalPressureReleased() {
		int sum = 0;
		
		for (int i=0; i<26; i++) {
			sum +=pressureReleased[i];
		}
		
		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (OpenedValve openedValve : openedValves) {
			sb.append(openedValve.valve().getId()).append(" (").append(openedValve.elapsedTime()).append(")")
					.append("->");
		}
		sb.append(" Total release : [").append(totalPressureReleased()).append("]");
		return sb.toString();
	}
}
