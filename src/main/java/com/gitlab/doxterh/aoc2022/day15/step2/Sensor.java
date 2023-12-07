package com.gitlab.doxterh.aoc2022.day15.step2;

public record Sensor(Coord coord, Beacon beacon) {
	public int distanceToBeacon() {
		return Distance.between(coord, beacon.coord());
	}
}
