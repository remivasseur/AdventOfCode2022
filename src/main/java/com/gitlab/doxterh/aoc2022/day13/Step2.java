package com.gitlab.doxterh.aoc2022.day13;

import java.util.ArrayList;
import java.util.List;

import com.gitlab.doxterh.aoc2022.utils.Logger;

public class Step2 {
	
	
	public static void main(String[] args) {
		Logger.ENABLE = false;
		int result = resolve(Data.GAME.split("\n"));
		
		System.out.println(result);
	}


	public static int resolve(String[] lines) {
		List<Value> values = new ArrayList<Value>();
		for (int i=0; i < lines.length;i++) {
			if (i%3 == 2) {
				continue;
			}
			Value value = new Value(lines[i]);
			values.add(value);
		};
		
		values.add(new Value("[[2]]"));
		values.add(new Value("[[6]]"));
		
		values.sort((left, right) -> left.compare(right));
		
		values.forEach(Logger::debug);
		
		int result = 1;
		int countDividerPacket = 0;
		for(int i = 0; i < values.size(); i++) {
			Value value = values.get(i);
			int index = i + 1;
			
			if (value.rawValue.equals("[[2]]") || value.rawValue.equals("[[6]]") ) {
				result = result * index;
				countDividerPacket ++;
			}
		}
		System.err.println(countDividerPacket);
		return result;
	}
	

}
