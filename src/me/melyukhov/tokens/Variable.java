package me.melyukhov.tokens;

import me.melyukhov.factory.TokenType;

public class Variable implements Token{

	private String name = "";
	private Token parent;
	
	public Variable() {
		
	}
	
	public Variable(String name) {
		this.name = name;
	}
	
	public Variable(String name, Token parent) {
		this.name = name;
		this.parent = parent;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Token getParent() {
		return parent;
	}

	@Override
	public Token[] getSons() {
		return null;
	}

	@Override
	public void setParent(Token parent) {
		this.parent = parent;
	}

	
	@Override
	public TokenType getType() {
		return TokenType.VARIABLE;
	}

	@Override
	public void setSon(Token... sons) {
				
	}

	@Override
	public void addSon(Token son) {
		this.setSon(son);
	}
}
