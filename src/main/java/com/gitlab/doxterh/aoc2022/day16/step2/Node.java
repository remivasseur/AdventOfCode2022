package com.gitlab.doxterh.aoc2022.day16.step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
	private final String nodeId;
	private int flowRate;
	private final List<Node> neighboors = new ArrayList<>();
	private boolean isVisited;
	private Node parent;
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public List<Node> getPath() {
		List<Node> path = new ArrayList<>();
		if (parent != null) {
			path.addAll(parent.getPath());
		}
		path.add(this);
		return path;
	}
	
	public List<Node> getNeighboors() {
		return this.neighboors;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public Node(String nodeId) {
		this.nodeId = nodeId;
	}
	
	public String getId() {
		return nodeId;
	}

	public void setFlowRate(int flowRate) {
		this.flowRate = flowRate;
	}
	
	public int getFlowRate() {
		return this.flowRate;
	}

	public void connect(Node node) {
		if (!this.neighboors.contains(node)) {
			this.neighboors.add(node);
		}
		if (!node.neighboors.contains(this)) {
			node.neighboors.add(this);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(neighboors, nodeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		return Objects.equals(nodeId, other.nodeId);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		//"Valve AA has flow rate=0; tunnels lead to valves DD, II, BB";
		sb.append("Valve ").append(nodeId).append(" has flow rate=").append(flowRate).append("; ");
		sb.append("tunnels lead to valves ");
		
		for (int i=0; i < neighboors.size(); i++) {
			if (i > 0) {
				sb.append(", ");
			}
			Node neighboor = neighboors.get(i);
			sb.append(neighboor.nodeId);
		}
		return sb.toString();
	}

}
