package com.gitlab.doxterh.aoc2022.day13;

import java.util.ArrayList;
import java.util.List;

import com.gitlab.doxterh.aoc2022.utils.Logger;

public class Value {
	public final String rawValue;
	public boolean isList = false;
	public boolean isInteger = false;

	public final List<Value> elements;
	
	public int size() {
		return elements.size();
	}

	public Value(String value) {
		this.rawValue = value;
		this.elements = parse(value);
	}
	
	public Integer intValue() {
		if (isInteger) {
			return Integer.parseInt(rawValue);
		} else {
			throw new RuntimeException(rawValue + " is not an int");
		}
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
	public int compare(Value right) {
		return compare(right, "");
	}
	
	public int compare(Value right, String prefix) {
		
		Logger.debug(prefix + "- Compare " + this + " vs " + right);
		
		if (this.isInteger && right.isInteger) {
			int result = this.intValue().compareTo(right.intValue());
			
			if (result < 0) {
				Logger.debug(prefix + "\t- Left side is smaller, so inputs are in the right order");
			} else if (result > 0) {
				Logger.debug(prefix + "\t- Right side is smaller, so inputs are not in the right order");
			}
			
			return result;
		} else if (this.isInteger && right.isList) {
			Logger.debug(prefix + "\t- Mixed types; convert left to ["+this.rawValue+"] and retry comparison");
			
			return new Value("[" + this.rawValue + "]").compare(right, prefix + "\t");
		} else if (this.isList && right.isInteger) {
			Logger.debug(prefix + "\t- Mixed types; convert right to ["+right.rawValue+"] and retry comparison");
			
			return this.compare(new Value("[" + right.rawValue +  "]"), prefix + "\t");
		} else {
			for (int i = 0; i < Math.max(size(), right.size()); i++) {

				if (i < size() && i < right.size()) {
					Value leftValue = elements.get(i);
					Value rightValue = right.elements.get(i);
					
					int result = leftValue.compare(rightValue, prefix + "\t");
					
					if (result != 0) {
						return result;
					}
				} else if (i >= size()){
					Logger.debug(prefix + "\t- Left side ran out of items, so inputs are in the right order");
					return -1;
				} else if (i >= right.size()){
					Logger.debug(prefix + "\t- Right side ran out of items, so inputs are not in the right order");
					return 1;
				}else {
					break;
				}
			}
		}
		
		return 0;
	}

}
