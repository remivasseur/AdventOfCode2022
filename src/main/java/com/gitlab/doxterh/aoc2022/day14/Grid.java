package com.gitlab.doxterh.aoc2022.day14;

public class Grid {
	private int minX, minY, maxX, maxY;
	
	private Cell[][] cells;


	public Grid(int minX, int minY, int maxX, int maxY) {
		super();
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
		
		int width = maxX - minX + 1;
		int height = maxY - minY + 1;
		
		cells = new Cell[width][];
		for (int x = 0; x < width; x++) {
			
			cells[x] = new Cell[height];
			
			for (int y=0; y < height; y++) {
				cells[x][y] = new Cell(new Coord(x,y), '.');
			}
		}
		
	}
	
	public void addLine(Line line) {
		line.forEach(coord -> {
			get(coord.x(), coord.y()).value('#');
		});
		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			sb.append("    ");
			for (int x = 0; x < cells.length; x++) {
				String xString = padLeft(x + minX, 3);
				sb.append(xString.charAt(i));
			}
			sb.append("\n");
		}
		
		for (int y = 0; y < cells[0].length; y++) {
			
			for (int x = 0; x < cells.length; x++) {
				
				if (x == 0) {
					sb.append(padLeft(y + minY, 3)).append(' ');
				}
				
				
				Cell cell = cells[x][y];
				sb.append(cell.value());
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}

	public Cell get(int x, int y) {
		return cells[x - minX][y - minY];
	}
	
	
	private String padLeft(int value, int length) {
		String inputString = String.valueOf(value);
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append(' ');
	    }
	    sb.append(inputString);

	    return sb.toString();
	}
}
