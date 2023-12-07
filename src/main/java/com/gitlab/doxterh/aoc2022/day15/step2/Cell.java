package com.gitlab.doxterh.aoc2022.day15.step2;

public class Cell {
	private Coord coord;
	private char value;
	
	public Cell(Coord coord, char value) {
		this.coord = coord;
		this.value = value;
	}
	
	public Coord coord() {
		return coord;
	}

	public char value() {
		return value;
	}
	
	public void value(char value) {
		this.value = value;
	}
	
	
}
