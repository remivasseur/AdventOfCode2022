package com.gitlab.doxterh.aoc2022.day15.step2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Consumer;

public class Grid {
	
	private List<Beacon> beacons;
	private List<Sensor> sensors;
	private List<Range> ranges = new ArrayList<>();
	
	public List<Range> getRanges() {
		return this.ranges;
	}

	private Map<String, Cell> cells = new HashMap<>();


	
	public void forEachSensor(Consumer<Sensor> sensor) {
		this.sensors.forEach(sensor);
	}

	public Cell get(int x, int y) {		
		return cells.getOrDefault(x + "_" + y , new Cell(new Coord(x, y), '.'));
	}
	
	public Cell set(int x, int y, char value) {		
		Cell cell = cells.getOrDefault(x + "_" + y , new Cell(new Coord(x, y), '.'));
		cell.value(value);
		cells.put(x + "_" + y, cell);
		return cell;
	}
	
	public void setBeacons(List<Beacon> beacons) {
		this.beacons = beacons;
		for(Beacon beacon : beacons) {
			set(beacon.coord().x(), beacon.coord().y(),'B');
		}
	}


	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
		int i = 0;
		for(Sensor sensor : sensors) {
			set(sensor.coord().x(), sensor.coord().y(),'S');
		}

		
	}

	public Range checkWhereNoBeacon(Sensor sensor, int line) {
		int distance = sensor.distanceToBeacon();

		int minY = sensor.coord().y() - distance;
		int maxY = sensor.coord().y() + distance;
		
		if (minY <= line && line <= maxY) {
		
			int tmpMinX = sensor.coord().x() - sensor.distanceToBeacon() + Math.abs(sensor.coord().y() - line);
			int tmpMaxX = sensor.coord().x() + sensor.distanceToBeacon() - Math.abs(sensor.coord().y() - line);
			
			int minX = Math.min(tmpMinX, tmpMaxX);
			int maxX = Math.max(tmpMinX, tmpMaxX);
			
			return new Range(minX, maxX);
			
			//System.out.println("\t[" + minX + "-" + maxX + "]");

		} else {
			return null;
		}	
	}

	public List<Range> calculateRangeWhereNoBeacon(int lineNumber) {
		List<Range> ranges = new ArrayList<>();
		for (Sensor sensor : sensors) {
			Range range = checkWhereNoBeacon(sensor, lineNumber);
			if (range != null) {
				ranges.add(range);
			}

		}
		ranges = correctRanges(ranges);
		return ranges;
	}
	
	public static List<Range> correctRanges(List<Range> ranges) {
		List<Range> remainingRanges = new ArrayList<>();
		Queue<Range> rangeQueue = new ArrayDeque<>();
		rangeQueue.addAll(ranges);

		while (!rangeQueue.isEmpty()) {
			Range currentRange = rangeQueue.remove();

			remainingRanges.add(currentRange);

			List<Range> includedRanges = ranges.stream().filter(
					r -> !r.equals(currentRange) && r.min() >= currentRange.min() && r.max() <= currentRange.max())
					.toList();

			if (!includedRanges.isEmpty()) {
				includedRanges.forEach(range -> {
					rangeQueue.remove(range);
					remainingRanges.remove(range);
				});
			}

			Optional<Range> overlappingRange = ranges.stream().filter(
					r -> !r.equals(currentRange) && ((r.min() < currentRange.min() && r.max() >= currentRange.min()-1)
							|| (r.min() <= currentRange.max()+1 && r.max() > currentRange.max())))
					.findFirst();

			overlappingRange.ifPresent(range -> {
				Range bigRange = new Range(Math.min(range.min(), currentRange.min()),
						Math.max(range.max(), currentRange.max()));

				remainingRanges.remove(currentRange);
				remainingRanges.remove(range);
				
				ranges.remove(currentRange);
				ranges.remove(range);
				
				ranges.add(bigRange);

				rangeQueue.remove(range);
				rangeQueue.add(bigRange);
			});
		}

		return remainingRanges;

	}
}
