package com.gitlab.doxterh.aoc2022.day15.step2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gitlab.doxterh.aoc2022.day15.Data;
import com.gitlab.doxterh.aoc2022.utils.Logger;

public class Step2 {

	public static void main(String[] args) {
		Logger.ENABLE = true;
		BigDecimal result = resolve(Data.GAME.split("\n"), 0, 4000000);
		//long result = resolve(Data.TEST.split("\n"), 0, 20);
		System.out.println(result);
	}

	public static BigDecimal resolve(String[] lines, int min, int max) {
		Grid grid = initGrid(lines);
		Coord beacon = null;
		for (int i = min; i <= max; i++) {
			Coord tmpCoord = resolve(grid, i);
			if (tmpCoord != null) {
				beacon = tmpCoord;
				break;
			}
		}
		System.out.println(beacon);
		
		BigDecimal x = new BigDecimal(beacon.x());
		BigDecimal y = new BigDecimal(beacon.y());
		BigDecimal coeff = new BigDecimal(4000000);
		
		BigDecimal result = x.multiply(coeff).add(y);

		
		return result;
	}

	public static Coord resolve(Grid grid, int line) {
		List<Range> ranges = grid.calculateRangeWhereNoBeacon(line);

		if (ranges.size() >= 2) {
			ranges.sort(Comparator.comparing(Range::min));
			System.out.println("Line " + line + ": " + ranges);
			Range range1 = ranges.get(0);
			Range range2 = ranges.get(1);
			if (range1.max() + 1 == range2.min() - 1) {
				return new Coord(range1.max() + 1, line);
			}
		}

		return null;
	}

	private static Grid initGrid(String[] lines) {
		List<Beacon> beacons = new ArrayList<>();
		List<Sensor> sensors = new ArrayList<>();

		for (String line : lines) {
			Line parsedLine = parseLine(line);

			Beacon beacon = parsedLine.beacon();
			beacons.add(beacon);
			Sensor sensor = parsedLine.sensor();
			sensors.add(sensor);
		}
		Grid grid = new Grid();
		grid.setBeacons(beacons);
		grid.setSensors(sensors);

		return grid;
	}

	public static Line parseLine(String line) {
		String regex = "x=(-?\\d+),\\s*y=(-?\\d+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);

		Coord sensorCoord = null;
		Coord beaconCoord = null;
		int matchCount = 0;
		while (matcher.find() && matchCount < 2) {
			int x = Integer.parseInt(matcher.group(1));
			int y = Integer.parseInt(matcher.group(2));

			if (matchCount == 0) {
				sensorCoord = new Coord(x, y);
			} else {
				beaconCoord = new Coord(x, y);
			}

			matchCount++;
		}

		Beacon beacon = new Beacon(beaconCoord);
		Sensor sensor = new Sensor(sensorCoord, beacon);

		return new Line(sensor, beacon);
	}

}
