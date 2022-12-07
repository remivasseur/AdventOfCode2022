package com.gitlab.doxterh.aoc2022.day07;

public class File {
	private final long size;
	private final String name;

	public File(long size, String name) {
		super();
		this.size = size;
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public String getName() {
		return name;
	}

}
