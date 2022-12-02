package com.gitlab.doxterh.aoc2022.day01;

import com.gitlab.doxterh.aoc2022.file.Loader;

public class Main {

	public static void main(String[] args) {
		Main.resolve("data.txt");

	}
	
	public static int resolve(String fileName) {
		Loader.loadFile(fileName);
		return 1;
	}

}
