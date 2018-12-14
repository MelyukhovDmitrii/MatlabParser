package me.melyukhov;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import me.melyukhov.lexer.Lexer;
import me.melyukhov.tree.Parser;

public class Main {
	public static void main(String[] args) throws IOException {
		String every;
		BufferedReader br = new BufferedReader(new FileReader("/home/dredd/Desktop/Parser/src/me/melyukhov/file.txt"));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }	
		    String everything = sb.toString();
		    every = everything;
		} finally {
		    br.close();
		}
		
		Lexer tz = new Lexer(every); 
		String[] s = tz.getStrings();
		Parser tr = new Parser();
		tr.parse(s); 
		tr.semanticsAnalysis();
	}
}
