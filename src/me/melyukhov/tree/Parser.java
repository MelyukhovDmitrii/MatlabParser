package me.melyukhov.tree;

import static me.melyukhov.factory.TokenFactory.make;
import static me.melyukhov.factory.TokenType.DISP;
import static me.melyukhov.factory.TokenType.FUNCTION;
import static me.melyukhov.factory.TokenType.FUNCTION_NAME;
import static me.melyukhov.factory.TokenType.OPERATION;
import static me.melyukhov.factory.TokenType.STRING;
import static me.melyukhov.factory.TokenType.VALUE;
import static me.melyukhov.factory.TokenType.VARIABLE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import me.melyukhov.table.Table;
import me.melyukhov.tokens.Token;

public class Parser {
	
	private int state = 1;
	private String ss = "qwertyuiopasdfghjklzxcvbnm1234567890";
	
	private static HashMap<String, HashMap<Integer, Integer>> table = new Table();
	
	private ArrayList<Character> stringSymbols = new ArrayList<>(ss.chars().mapToObj(e->(char) e).collect(Collectors.toList()));
	private ArrayList<Token> STRINGS = new ArrayList<>();

	private final List<Character> numbers = Collections.unmodifiableList(Arrays.asList(new Character[]{ '1','2','3','4','5','6','7','8','9','0' }));
	
	private ArrayList<String> declaretedVariables = new ArrayList<>();
	private ArrayList<String> initializedVariables = new ArrayList<>();
	private ArrayList<String> usedVariables = new ArrayList<>();		
	private ArrayList<String> returnedVariables = new ArrayList<>();	
	
	private Token previous;
	private Token pastWord;
	private Token root;
	
	public Parser() {	}
	
	public void parse(String[] in) {
		for(String i: in) {
			add2(i);
		}
	}
	
	static Integer stringNumber = 0;
	
	public void add2(String word) {
		switch(this.state) {
		case 1: 
			previous = make(FUNCTION, word);
			break;
		case 2: 
			previous.setParent(make(OPERATION, word));
			root = previous.getParent();
			root.setSon(new Token[]{previous, null});
			break;
		case 3: 
			previous = make(FUNCTION_NAME, word);
			previous.setParent(root);
			Token[] qwe = {root.getSons()[0],previous};
			root.setSon(qwe);
			break;
		case 4:
			break; 
		case 5:
			if(!word.equals(")")) {
				previous.addSon(make(VARIABLE, word));
				declaretedVariables.add(word);
				initializedVariables.add(word);
			} else {
				STRINGS.add(root);
				clear();
			}
			break;
		case 6:
			if(word.equals(")")) {
				STRINGS.add(root);
				clear();
			}
			break;
		case 7:
			if(word.equals("disp")) pastWord = make(DISP, word);
			else {
				root = make(VARIABLE, word);
				declaretedVariables.add(word);
			}
			break;
		case 8:
			if(word.equals(";")) {
				STRINGS.add(root);
				clear();
			} else {
				root.setParent(make(OPERATION, word));
				root.getParent().setSon(root, null);
				initializedVariables.add(root.getName());
				root = root.getParent();
				pastWord = root;
			}
			break;
		case 9:
			Token t = isNumber(word) ? make(VALUE, word) : make(VARIABLE, word);
			if(t.getType() == VARIABLE) usedVariables.add(t.getName());
			root.setSon(root.getSons()[0], t);
			break;
		case 10:
			if(word.equals(";")) {
				STRINGS.add(pastWord);
				clear();
			} else {
				Token h = root.getSons()[1];
				root.setSon(root.getSons()[0], make(OPERATION, word));
				root = root.getSons()[1];
				root.setSon(h, null);
			}
			break;
		case 11:;
		case 12:
			break;
		case 13:
			Token ts = isNumber(word) ? make(VALUE, word) : make(VARIABLE, word);
			if(ts.getType() == VARIABLE) usedVariables.add(ts.getName());
			pastWord.addSon(ts);
			break;
		case 14:
			STRINGS.add(pastWord);
			clear();
			break;
		case 15:
			break;
		case 16:
			break;
		case 17:
			if(!word.equals("]")) {
				previous.addSon(make(VARIABLE, word));
				returnedVariables.add(word);
			}
			break;
		default:; 
		}
		int st=getState(word);
		this.state = st;
	}
	
	private void clear() {
		root = null;
		previous = null;
		pastWord = null;
	}	
	
	
	private int getState(String word) {
		if(!word.equals("function")) {
			if(isNumber(word)) {
				word = "number";
			} else {
				if(defineVariable(word)){	
					word = word.equals("disp") ? word : "name";
				}
			}
		}
		return (int) table.get(word).get(this.state);
	}
	
	private boolean isNumber(String word) {
		for(char i: word.toCharArray()) {
			if(!numbers.contains(i)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean defineVariable(String ceil) {
		for(char i: ceil.toCharArray()) {
			if(!stringSymbols.contains(i)) {
				return false;
			}
		}
		return true;
	}
	
	public void semanticsAnalysis() {
		int i = 0;
		String[] variables = usingUnimlplementVariable();
		if(variables != null) {
			i++;
			System.out.print("Использование необъявленного индентификатора: ");
			for(int j = 0; j < variables.length; j++) {
				System.out.print(variables[j]);
				if(j < variables.length-1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
		
		variables = unusingDeclaratedVariable();
		if(variables != null) {
			i++;
			System.out.print("Неиспользование объявленного идентификатора: ");
			for(int j = 0; j < variables.length; j++) {
				System.out.print(variables[j]);
				if(j < variables.length-1) {
					System.out.print(", ");	
				}
			}
			System.out.println();
		}
		
		variables = functionNotReturnedVariable();
		if(variables != null) {
			i++;
			System.out.print("Возвращающая переменная не инициализирована: ");
			for(int j = 0; j < variables.length; j++) {
				System.out.print(variables[j]);
				if(j < variables.length-1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
		
		if(i == 0) System.out.println("Ошибок нет");
	}
	

	private String[] usingUnimlplementVariable() {
		
		ArrayList<String> error = new ArrayList<>();
		
		for(int i = 0; i < usedVariables.size(); i++) {
			if(!initializedVariables.contains(usedVariables.get(i))) {
				error.add(usedVariables.get(i));
			}
		}
		
		if(error.size() == 0) {
			return null;
		} else {
			String[] out = new String[error.size()];
			out = error.toArray(out);
			return out;
		}
	}
	
	private String[] unusingDeclaratedVariable() {
		
		ArrayList<String> error = new ArrayList<>();
		
		for(int i = 0; i < declaretedVariables.size(); i++) {
			if(!usedVariables.contains(declaretedVariables.get(i))) {
				error.add(declaretedVariables.get(i));
			}
		}
		
		if(error.size() == 0) {
			return null;
		} else {
			String[] out = new String[error.size()];
			out = error.toArray(out);
			return out;
		}
	}
	
	private String[] functionNotReturnedVariable() {
		ArrayList<String> error = new ArrayList<>();
		
		for(int i = 0; i < returnedVariables.size(); i++) {
			if(!initializedVariables.contains(returnedVariables.get(i))) {
				error.add(returnedVariables.get(i));
			}
		}
		
		if(error.size() == 0) {
			return null;
		} else {
			String[] out = new String[error.size()];
			out = error.toArray(out);
			return out;
		}
	}
	
}
