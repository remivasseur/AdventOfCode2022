package com.gitlab.doxterh.aoc2022.day14;

import java.util.ArrayList;
import java.util.List;

import com.gitlab.doxterh.aoc2022.utils.Logger;

public class Step1 {

	public static void main(String[] args) {
		Logger.ENABLE = true;
		resolve(Data.TEST.split("\n"));

	}

	public static void resolve(String[] lines) {

		Grid grid = initGrid(lines);
		grid.get(500,0).value('+');
		
		Logger.debug(grid);

	}

	private static Grid initGrid(String[] lines) {

		int minX = 500;
		int maxX = 500;
		int minY = 0;
		int maxY = 0;

		List<Line> pointLines = new ArrayList<>();
		// int i=1;
		for (String line : lines) {
			String[] coordinates = line.split(" -> ");

			List<Coord> points = new ArrayList<>();

			for (String coordinate : coordinates) {
				String[] tmp = coordinate.split(",");
				int x = Integer.parseInt(tmp[0]);
				int y = Integer.parseInt(tmp[1]);

				points.add(new Coord(x, y));

				if (x > maxX) {
					maxX = x;
				}
				if (x < minX) {
					minX = x;
				}
				if (y > maxY) {
					maxY = y;
				}
				if (y < minY) {
					minY = y;
				}

				// Logger.debug("x: " + x + " / y: " + y);
			}
			Line pointLine = new Line(points);
			pointLines.add(pointLine);

		}
		Grid grid = new Grid(minX, minY, maxX, maxY);
		
		pointLines.forEach(grid::addLine);
		
		
		return grid;
	}

	

}
