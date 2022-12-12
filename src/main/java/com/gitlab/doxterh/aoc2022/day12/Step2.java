package com.gitlab.doxterh.aoc2022.day12;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Step2 {

	public static void main(String[] args) {

		String[] lines = Data.GAME.split("\n");

		int width = lines[0].length();
		int height = lines.length;

		Node[][] grid = new Node[height][width];

		int[] start = { -1, -1 };
		int[] end = { -1, -1 };

		Node nodeStart = null;

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {

				char car = lines[y].charAt(x);

				final Node node = new Node();

				if (car == 'S') {
					car = 'a';
					start = new int[] { y, x };

					nodeStart = node;

				} else if (car == 'E') {
					car = 'z';
					end = new int[] { y, x };

					node.isEnd = true;
				}

				node.value = car;

				grid[y][x] = node;

			}

		}

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Node node = grid[y][x];

				if (x > 0) {
					Node leftNode = grid[y][x-1];
					
					if (node.value >= leftNode.value -1) {
						node.neighbors.add(leftNode);
					}
				}
				
				if (x < width -1) {
					Node rightNode = grid[y][x+1];
					
					if (node.value >= rightNode.value -1) {
						node.neighbors.add(rightNode);
					}
				}
				
				if (y > 0) {
					Node topNode = grid[y-1][x];
					
					if (node.value >= topNode.value -1) {
						node.neighbors.add(topNode);
					}
				}
				
				if (y < height -1) {
					Node bottomNode = grid[y+1][x];
					
					if (node.value >= bottomNode.value -1) {
						node.neighbors.add(bottomNode);
					}
				}

			}

		}
		

	

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				//System.out.println(x + ","+ y + ": " + grid[y][x].value + " -> neigh : " + grid[y][x].neighbors );
				//System.out.print(grid[y][x]);

			}
			//System.out.println();
		}

		System.out.println("\nStart : " + grid[start[0]][start[1]]);
		System.out.println("\nEnd : " + grid[end[0]][end[1]]);
		
		Node searchEnd = search(nodeStart);

		List<Node> path = searchEnd.getList();
		System.out.println(path);
		
		System.out.println("steps : " + (path.size() -1));
	}
	
	public static Node search(Node start) {
		Queue<Node> queue = new ArrayDeque<Node>();

		queue.add(start);

		Node currentNode;
		
		while (!queue.isEmpty()) {

			currentNode = queue.remove();
			if (currentNode.isEnd) {
				return currentNode;
			} else {
				final Node tmp = currentNode;
				tmp.visited = true;

				List<Node> neighBorsNotVisited = currentNode.neighbors.stream()
						.filter(node -> !node.visited && !queue.contains(node))
						.collect(Collectors.toList());
				neighBorsNotVisited.forEach(node -> node.parent = tmp);

				queue.addAll(neighBorsNotVisited);
				queue.removeIf(node -> node.visited);
			}
		}
		return null;
	}

}
