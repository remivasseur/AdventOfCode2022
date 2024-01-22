package com.gitlab.doxterh.aoc2022.day16.step2;

public class Parser {
	public static void parse(String[] lines) {
		for (String line : lines) {
			parseLine(line);
		}
	}
	private static void parseLine(String line) {
		System.out.println(line);
		String[] values = line.split(";");
		Node node = parseNewNode(values[0]);
		parseNeighboor(node, values[1]);
	}
	
	private static Node parseNewNode(String line) {
		//System.out.println(line);
		int index = line.indexOf(" has flow rate");
		//System.out.println(index);
		String nodeIndex = line.substring(6, index);
		int flowRate = Integer.valueOf(line.split("has flow rate=")[1]);
		//System.out.println(nodeIndex + ":" + flowRate);
		
		return Graph.createNode(nodeIndex, flowRate);
	}
	
	private static void parseNeighboor(Node node, String line) {
		String pattern = "tunnels lead to valves ";
		int index = line.indexOf(pattern);
		String[] values = line.substring(index + pattern.length()).split(",");
		
		for (String value : values) {
			node.connect(Graph.getNode(value.trim()));
		}
	}
}
