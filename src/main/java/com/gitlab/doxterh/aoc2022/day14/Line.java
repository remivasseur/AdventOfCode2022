package com.gitlab.doxterh.aoc2022.day14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public record Line(List<Coord> points) {
	public void forEach(Consumer<Coord> consumer) {
		List<Coord> allPoints = new ArrayList<>();
		
		for (int i = 0; i < points.size() - 1; i++) {
			Coord currentPoint = points().get(i);
			Coord nextPoint = points().get(i+1);
			
			if (currentPoint.x() == nextPoint.x()) {
				
				int minY = Math.min(currentPoint.y(), nextPoint.y());
				int maxY = Math.max(currentPoint.y(), nextPoint.y());
				
				
				for (int y=minY; y <= maxY; y++) {
					allPoints.add(new Coord(currentPoint.x(), y));
				}
			}
			if (currentPoint.y() == nextPoint.y()) {
				int minX = Math.min(currentPoint.x(), nextPoint.x());
				int maxX = Math.max(currentPoint.x(), nextPoint.x());
				
				for (int x=minX; x <= maxX; x++) {
					allPoints.add(new Coord(x, currentPoint.y()));
				}
			}
		}

		allPoints.forEach(consumer);
	}
}
