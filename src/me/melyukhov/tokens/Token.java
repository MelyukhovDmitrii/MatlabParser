package me.melyukhov.tokens;

import me.melyukhov.factory.TokenType;

public interface Token {
	
	public String getName();
	
	public Token getParent();
	public Token[] getSons();
	
	public void setName(String name);
	public void setParent(Token parent);
	public void setSon(Token... sons);
	public void addSon(Token son);
	
	public TokenType getType();
	
}
