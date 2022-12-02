package com.gitlab.doxterh.aoc2022.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Loader {
	public static List<String> loadFile(String fileName) {
		
		List<String> lines = new ArrayList<>();
		
		InputStream is = Loader.class.getResourceAsStream("test.csv");
		
		
		try (BufferedReader br =new BufferedReader(new
		         InputStreamReader(Loader.class.getResourceAsStream(fileName)))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	lines.add(line);
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lines;
	}
}
