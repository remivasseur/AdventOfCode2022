package com.gitlab.doxterh.aoc2022.day13;

import java.util.ArrayList;
import java.util.List;

public class Value {
	public final String rawValue;

	public final List<Value> elements;

	public Value(String value) {
		this.rawValue = value;
		this.elements = parse(value);
	}

	public List<Value> parse(String value) {
		System.err.println("Parsing " + value);
		List<Value> elements = new ArrayList<Value>();

		int index = 0;
		int startOffset = 0;
		int endOffset = 0;
		int level = 0;
		String tmpValue;
		for (char c : value.toCharArray()) {
			tmpValue = value.substring(startOffset, endOffset);
			if (c == '[') {
				if (index == 0) {
					startOffset = index + 1;
					endOffset = startOffset;
				} else {
					level++;
					startOffset = index;
					endOffset = startOffset;
				}
			} else if (c == ']') {
				if (index == value.length() - 1) {
					elements.add(new Value(value.substring(startOffset, index)));
				} else {
					level--;

				}
			}

			else if (c == ',' && level==0) {
				elements.add(new Value(value.substring(startOffset, index)));
				startOffset += tmpValue.length() + 1;
				endOffset = startOffset;
			} else {
				endOffset++;
			}

			index++;
		}

		return elements;
	}

	public String toString() {
		return rawValue;
	}

}
