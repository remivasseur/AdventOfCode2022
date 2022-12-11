package com.gitlab.doxterh.aoc2022.day07;

import java.util.List;

public class Step1 {

	public static void main(String[] args) {

		Dir root = getFileSystem(Data.GAME.split("\n"));

		// System.out.println(root);

		List<Dir> allSubDirectories = root.getSubDirectories();

		long sum = 0;

		System.out.println("Total size : " + root.getSize());
		long unusedSpace = 70000000 - root.getSize();
		System.out.println("Unused space : " + unusedSpace);
		long spaceToBeFree = 30000000 - unusedSpace;
		System.out.println("Space to be freed : " + spaceToBeFree);

		long smallestDirectorySize = Long.MAX_VALUE;
		for (Dir dir : allSubDirectories) {

			if (dir.getSize() >= spaceToBeFree) {
				System.out.println(dir.getName() + " of size " + dir.getSize());
				
				if (dir.getSize() < smallestDirectorySize) {
					smallestDirectorySize = dir.getSize();
				}
			}

		}
		
		System.out.println("Size of directory to delete : " + smallestDirectorySize);
		
		
	}

	public static Dir getFileSystem(String[] lines) {
		Dir root = new Dir(true);

		Dir currentDirectory = root;
		String[] currentCommand = null;

		for (int i = 0; i < lines.length; i++) {

			String[] arg = lines[i].split(" ");

			if ("$".equals(arg[0])) {
				currentCommand = arg;
			}

			if ("cd".equals(currentCommand[1])) {
				if ("/".equals(currentCommand[2])) {
					currentDirectory = root;
				} else if ("..".equals(currentCommand[2])) {
					currentDirectory = currentDirectory.getParentDirectory();
				} else {
					currentDirectory = currentDirectory.getDirectory(currentCommand[2]);
				}

			}

			if ("ls".equals(currentCommand[1]) && !"$".equals(arg[0])) {

				if ("dir".equals(arg[0])) {
					currentDirectory.addDir(arg[1]);
				} else {
					currentDirectory.addFile(new File(Long.valueOf(arg[0]), arg[1]));
				}

			}

		}

		return root;
	}

}
