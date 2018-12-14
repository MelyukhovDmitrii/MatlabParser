package me.melyukhov.tokens;

import me.melyukhov.factory.TokenType;

public class Value implements Token
{
	private String name = "";
	private Token parent;
	private Token son;
	
	public Value() {
		
	}
	
	public Value(String name) {
		this.name = name;
	}
	
	public Value(String name, Token parent) {
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
	public void setParent(Token parent) {
		this.parent = parent;
	}
	
	@Override
	public TokenType getType() {
		return TokenType.VALUE;
	}

	@Override
	public Token[] getSons() {
		return new Token[] {son};
	}

	@Override
	public void setSon(Token... sons) {
		son = sons[0];
		
	}

	@Override
	public void addSon(Token son) {
		this.setSon(son);
	}
}
