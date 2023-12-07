package com.gitlab.doxterh.aoc2022.day15.step2;

public class Distance {
	public static int between(Coord origine, Coord destination) {
		return Math.abs(origine.x() - destination.x()) + Math.abs(origine.y() - destination.y());
	}
}
