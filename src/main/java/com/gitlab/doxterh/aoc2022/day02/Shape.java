package com.gitlab.doxterh.aoc2022.day02;

public enum Shape {
	ROCK(0,1,'A'), PAPER(1,2,'B'), SCISSORS(2,3,'C');
	
	private final int id;
	private final int score;
	private final char code;
	
	Shape(int id, int score, char code) {
		this.id = id;
		this.score = score;
		this.code = code;
	}
	
	public int id() {
		return this.id;
	}
	public int score() {
		return this.score;
	}
	public char code() {
		return this.code;
	}
	
	public static Shape fromCode(char code) {
		for (Shape shape : values()) {
			if (shape.code == code) {
				return shape;
			}
		}
		return null;
	}

	public static Shape fromId(int id) {
		for (Shape shape : values()) {
			if (shape.id == id) {
				return shape;
			}
		}
		return null;
	}

}
