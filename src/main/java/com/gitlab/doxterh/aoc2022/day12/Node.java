package com.gitlab.doxterh.aoc2022.day12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node {
	public char value;
	
	public int x;
	public int y;
	
	public boolean isEnd = false;
	
	public List<Node> neighbors = new ArrayList<>();
	public Node parent;
	public boolean visited;
	
	@Override
	public String toString() {
		return ""+this.value;
	}
	
	public List<Node> getList() {
		List<Node> path = new ArrayList<>();
		Node iter = this;

		while (iter != null) {
			path.add(iter);
			iter = iter.parent;
		}
		Collections.reverse(path);
		return path;
	}
	
}
