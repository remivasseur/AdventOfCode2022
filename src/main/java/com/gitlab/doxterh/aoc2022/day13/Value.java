package com.gitlab.doxterh.aoc2022.day13;

import java.util.ArrayList;
import java.util.List;

public class Value {
	public final String rawValue;
	public boolean isList = false;
	public boolean isInteger = false;

	public final List<Value> elements;

	public Value(String value) {
		this.rawValue = value;
		this.elements = parse(value);
	}

	public List<Value> parse(String value) {
		List<Value> elements = new ArrayList<Value>();

		if (Character.isDigit(value.charAt(0))) {
			isList = false;
			isInteger = true;

			return null;
		} else if (value.charAt(0) == '[') {
			isList = true;
			isInteger = false;

			String subValue = value.substring(1, value.length() - 1);

			int index = 0;
			int startOffset = 0;
			int level = 0;
			for (char c : subValue.toCharArray()) {
				if (c == '[') {
					level++;
					if (level == 1) {
						startOffset = index;
					}
				} else if (c == ']') {
					level--;
				}

				else if (c == ',' && level == 0) {
					String tempValue = subValue.substring(startOffset, index);
					elements.add(new Value(tempValue));
					startOffset += tempValue.length() + 1;
				}

				if (index == subValue.length() - 1) {
					elements.add(new Value(subValue.substring(startOffset, index + 1)));
				}

				index++;
			}

			return elements;
		} else {
			return null;
		}

	}

	public String toString() {
		return rawValue;
	}

}
