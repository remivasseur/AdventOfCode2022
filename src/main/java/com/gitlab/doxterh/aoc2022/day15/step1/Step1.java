package com.gitlab.doxterh.aoc2022.day15.step1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gitlab.doxterh.aoc2022.day15.Data;
import com.gitlab.doxterh.aoc2022.utils.Logger;

public class Step1 {
	
	public static List<Integer> onSameLine = new ArrayList<>();

	public static void main(String[] args) {
		Logger.ENABLE = true;
		//int result = resolve(Data.GAME.split("\n"), 2000000);
		int result = resolve(Data.TEST.split("\n"), 10);
		System.out.println(result);
	}

	public static int resolve(String[] lines, int line) {
		int sum = 0;
		Grid grid = initGrid(lines, line);
		Collections.sort(onSameLine);
		
		System.out.println("Corrected Ranges : " + grid.getRanges());
		
		Range range = grid.getRanges().get(0);
		int impossibleValues = range.max() - range.min() + 1;
		
		
		for(int x : onSameLine) {
			if (x >= range.min() && x <= range.max() ) {
				impossibleValues--;
			}
		}

		return impossibleValues;
	}

	private static Grid initGrid(String[] lines, int lineNumber) {
		List<Beacon> beacons = new ArrayList<>();
		List<Sensor> sensors = new ArrayList<>();

		// int i=1;
		for (String line : lines) {
			Line parsedLine = parseLine(line);

			Beacon beacon = parsedLine.beacon();
			beacons.add(beacon);
			Sensor sensor = parsedLine.sensor();
			sensors.add(sensor);
			
			if (beacon.coord().y() == lineNumber && !onSameLine.contains(beacon.coord().x())) {
				onSameLine.add(beacon.coord().x());
			}
			if (sensor.coord().y() == lineNumber && !onSameLine.contains(sensor.coord().x())) {
				onSameLine.add(sensor.coord().x());
			}

		}
		Grid grid = new Grid();
		grid.setBeacons(beacons);
		grid.setSensors(sensors);
		
		grid.calculateRangeWhereNoBeacon(lineNumber);

		
		return grid;
	}



	public static Line parseLine(String line) {
		System.out.println(line);
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
