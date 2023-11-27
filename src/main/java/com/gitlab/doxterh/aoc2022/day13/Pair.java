package com.gitlab.doxterh.aoc2022.day13;

public class Pair {
	public Value left;
	public Value right;
	
	public Pair(String left, String right) {
		this.left = new Value(left);
		this.right = new Value(right);
	}

	public boolean compare() {
		System.out.println("- Compare " + this.left + " vs " + this.right);
		return false;
	}
}
