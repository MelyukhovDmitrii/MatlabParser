package me.melyukhov.lexer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lexer {
	private String input;
	private List<String> output = new ArrayList<>();
	private final List<String> tokens = Collections.unmodifiableList(Arrays.asList(new String[]{
				"function",
				"[",
				"]",
				",",
				"=",
				"(",
				")",
				";",
				"+", 
				"-",
				"*",
				"/",
				"disp",
				"END"
				
		}));
	
	public Lexer(String input) {
		this.input = input;
		
		String[] previous = this.input.split("\n");
		
		for(String k: previous) {
			k = k.replaceAll("\\s", "");
		}

		for(String i: previous) {
			output.add(i.replaceAll("\\s", ""));
		}
		
		ArrayList<String> srings = new ArrayList<>();

		for(int i = 0; i < output.size(); i++) {
			String[] qq = splitter(output.get(i));
			for(String l: qq) {
				srings.add(l);
			}
		}
		
		output = srings;
		
	}
	
	private String[] splitter(String in) {
		
		ArrayList<String> out = new ArrayList<>();
		
		char[] get = in.toCharArray();
		
		
		String g = ""; 
		
		for(char i: get) {
			if(tokens.contains(g)) {
				out.add(g);
				g = "";
				g = g + i;
			} else {
				if(tokens.contains(""+i)) {
					out.add(g);
					g="";
			
				}
				g = g + i;
			} 
		}
		out.add(g);
		
		String[] outputes = new String[out.size()];
		
		for(int i = 0; i < out.size(); i++) {
			outputes[i] = out.get(i);
		}
		
		return outputes;
	}
	
	public String[] getStrings() {
		String[] outputes = new String[output.size()];
		
		for(int i = 0; i < output.size(); i++) {
			outputes[i] = output.get(i);
		}
		
		return outputes;
	}
}