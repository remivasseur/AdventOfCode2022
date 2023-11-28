package com.gitlab.doxterh.aoc2022.utils;

public class Logger {
	public static boolean ENABLE = true;
	
	public static void debug(Object message) {
		if (ENABLE) {
			System.out.println(message.toString());
		}
	}
}
