package com.gitlab.doxterh.aoc2022.day07;

import java.util.ArrayList;
import java.util.List;

public class Dir {
	private final boolean isRoot;
	private final String name;
	
	private final List<Dir> directories = new ArrayList<>();
	private final List<File> files = new ArrayList<>();
	private final Dir parent;
	

	public Dir(String name, Dir parent) {
		this.isRoot = false;
		this.name = name;
		this.parent = parent;
	}
	
	public Dir(boolean isRoot) {
		this.isRoot = isRoot;
		this.name = "/";
		this.parent = null;
	}
	
	public boolean isRoot() {
		return this.isRoot;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Dir> getSubDirectories() {
		List<Dir> dirs = new ArrayList<>();
		dirs.add(this);
		for (Dir dir : this.directories) {
			dirs.addAll(dir.getSubDirectories());
		}
		
		return dirs;
	}
	
	public long getSize() {
		long size = 0;
		
		for (Dir dir : directories) {
			size += dir.getSize();
		}
		
		for(File file : files) {
			size += file.getSize();
		}
		
		return size;
	}
	
	public Dir getParentDirectory() {
		return this.parent;
	}

	public Dir getDirectory(String string) {
		return this.directories.stream().filter(dir -> string.equals(dir.name)).findFirst().orElse(null);
	}

	public void addDir(String dirName) {
		this.directories.add(new Dir(dirName, this));
		
	}

	public void addFile(File file) {
		this.files.add(file);
	}
	
	public int level() {
		Dir parent = this.parent;
		int level = 0;
		while(parent != null) {
			parent = parent.parent;
			level++;
		}
		
		return level;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i < this.level(); i++) {
			sb.append("  ");
		}
		sb.append("- ");
		sb.append(name);
		sb.append(" (dir)\n");
		
		for (Dir child : directories) {
			sb.append(child);
		}
		
		return sb.toString();
	}

	
}
