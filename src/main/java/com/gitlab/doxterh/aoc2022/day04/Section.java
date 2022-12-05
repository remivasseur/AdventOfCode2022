package com.gitlab.doxterh.aoc2022.day04;

import java.util.Objects;

public class Section {
	private final int from;
	private final int to;

	public Section(int endpoint1, int endpoint2) {
		if (endpoint1 <= endpoint2) {
			this.from = endpoint1;
			this.to = endpoint2;
		} else {
			this.from = endpoint2;
			this.to = endpoint1;
		}

	}
	
	public boolean overlapWith(Section section) {
		if (this.to < section.from || section.to < this.from)
		{
			return false;
		} else {
			return true;
		}
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(from, to);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		return from == other.from && to == other.to;
	}

	@Override
	public String toString() {
		return "[" +from + ", " + to + "]";
	}
	
	
	
}
