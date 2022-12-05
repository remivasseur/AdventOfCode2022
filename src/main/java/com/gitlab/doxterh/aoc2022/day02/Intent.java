package com.gitlab.doxterh.aoc2022.day02;

public enum Intent {
	WIN(6, 'Z'),DRAW(3,'Y'),LOOSE(0,'X');
	
	private int score;
	private char code;
	
	private Intent(int score, char code) {
		this.score = score;
		this.code = code;
	}
	
	public int score() {
		return this.score;
	}
	
	public char code() {
		return this.code;
	}
	
	public static Intent fromCode(char code) {
		for (Intent intent : values()) {
			if (intent.code == code) {
				return intent;
			}
		}
		return null;
	}
	
}
