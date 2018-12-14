package me.melyukhov.tokens;

import me.melyukhov.factory.TokenType;

public class Disp implements Token{

	private String name = "";
	private Token parent;
	private Token son;
	
	public Disp() {
		
	}
	
	public Disp(String name) {
		this.setName(name);
	}
	
	public Disp(String name, Token parent) {
		this.setName(name);
		this.setParent(parent);
	}
	
	@Override
	public String getName() {
		return name;
	}
	

	@Override
	public Token getParent() {
		return parent;
	}

	@Override
	public Token[] getSons() {
		return new Token[] { son };
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setParent(Token parent) {
		this.parent = parent;
	}

	@Override
	public void setSon(Token... sons) {
		this.son = sons[0];
		this.son.setParent(this);
	}

	@Override
	public TokenType getType() {
		return TokenType.DISP;
	}

	@Override
	public void addSon(Token son) {
		this.setSon(son);
	}
	
}
