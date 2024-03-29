package com.gitlab.doxterh.aoc2022.day14;

import java.util.ArrayList;
import java.util.List;

import com.gitlab.doxterh.aoc2022.utils.Logger;

public class Step1 {

	public static Grid grid;

	public static void main(String[] args) {
		Logger.ENABLE = true;
		resolve(Data.GAME.split("\n"));

	}

	public static void resolve(String[] lines) {

		grid = initGrid(lines);
		grid.get(500, 0).value('+');
		int i=0;
		while(true) {
			if (!addSand()) {
				break;
			}
			i++;
		}
		Logger.debug(grid);
		
		System.out.println("Grains de sable :" + i);
	}

	public static boolean addSand() {

		int sandX = 500;
		int sandY = 0;

		boolean isBlocked = false;
		while (true) {
			if (grid.get(sandX, sandY).value() == '!') {
				return false;
			}
			if (grid.get(sandX, sandY + 1).value() != '#' && grid.get(sandX, sandY + 1).value() != 'O') {
				sandY += 1;
			} else if (grid.get(sandX - 1, sandY + 1).value() != '#' && grid.get(sandX - 1, sandY + 1).value() != 'O') {
				sandY += 1;
				sandX -= 1;
			} else if (grid.get(sandX + 1, sandY + 1).value() != '#' && grid.get(sandX + 1, sandY + 1).value() != 'O') {
				sandY += 1;
				sandX += 1;
			} else {
				break;
			}

		}
		
		grid.get(sandX, sandY).value('O');
		return true;
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
