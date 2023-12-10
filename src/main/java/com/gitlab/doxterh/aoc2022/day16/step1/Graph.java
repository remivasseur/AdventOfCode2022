package com.gitlab.doxterh.aoc2022.day16.step1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;

public class Graph {
	private static Map<String, Node> nodes = new HashMap<>();
	private static List<Node> allNodes = new ArrayList<>();
	private static List<Node> nodesWithPressure = new ArrayList<>();
	private static Map<String, Integer> distances = new HashMap<>();
	
	public static void forEachNode(Consumer<Node> consumer) {
		allNodes.forEach(consumer);
	}
	
	public static void forEachPressureNode(Consumer<Node> consumer) {
		nodesWithPressure.forEach(consumer);
	}

	public static Node getNode(String nodeId) {
		return nodes.computeIfAbsent(nodeId, id -> new Node(id));
	}
	
	public static Node createNode(String nodeId, int flowRate) {
		Node newNode = getNode(nodeId);
		newNode.setFlowRate(flowRate);
		if (flowRate > 0) {
			nodesWithPressure.add(newNode);
		}
		allNodes.add(newNode);
		return newNode;
	}
	
	public static void clear() {
		allNodes.forEach(node -> {
			node.setVisited(false);
			node.setParent(null);
		});
	}
	
	public static int distance(Node source, Node destination) {
		clear();
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(source);
		
		Node currentNode;
		while (!queue.isEmpty()) {
			currentNode = queue.remove();

			if (currentNode.getId().equals(destination.getId())) {
				
				return currentNode.getPath().size() -1;
			} else {
				final Node tmp = currentNode;
				tmp.setVisited(true);
				
				for (Node neighbor : currentNode.getNeighboors()) {
					if (!neighbor.isVisited() && !queue.contains(neighbor)) {
						neighbor.setParent(currentNode);
						queue.add(neighbor);
					}
				}

				queue.removeIf(Node::isVisited);
			}
		}
		
		return -1;
	}

	public static void calculateDistanceBetweenEachPressureNode() {
		List<Node> nodesList = new ArrayList<>(nodesWithPressure);
		nodesList.add(Graph.getNode("AA"));
		
		for (Node nodeSource : nodesList) {
			for (Node nodeDestination : nodesList) {
				String idSource = nodeSource.getId();
				String idDestination = nodeDestination.getId();
				String key = idSource + "_" + idDestination;
				String reverseKey = idDestination + "_" + idSource;
				
				if (!idSource.equals(idDestination)) {
					int distance = distance(nodeSource, nodeDestination);
					
					if (distance > 0) {
						distances.put(key, distance);
						distances.put(reverseKey, distance);
					}
					
				}
				
			}
		}
		
	}
	
	public static int getDistance(Node source, Node destination) {
		String idSource = source.getId();
		String idDestination = destination.getId();
		String key = idSource + "_" + idDestination;
		
		//if (distances.containsKey(key)) {
			return distances.get(key);
		//} else {
		//	return distance(source, destination);
		//}
		
		
	}
}
