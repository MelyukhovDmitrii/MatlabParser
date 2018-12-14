package me.melyukhov.tokens;

import me.melyukhov.factory.TokenType;

public class Operation implements Token
{
	private String name = "";
	private Token parent;
	private Token firstOperand;
	private Token secondOperand;	
	
	public Operation() {
		
	}
	
	public Operation(String name) {
		this.name = name;
	}
	
	public Operation(String name, Token parent) {
		this.name = name;
		this.parent = parent;
	}
	
	public Operation(String name, Token parent, Token firstOperand) {
		this.name = name;
		this.parent = parent;
		this.firstOperand = firstOperand;
	}
	
	public Operation(String name, Token parent, Token firstOperand, Token secondOperand) {
		this.name = name;
		this.parent = parent;
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
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
	
	static int i = 0;
	
	@Override
	public void addSon(Token son) {
		
	}
	
	@Override
	public TokenType getType() {
		return TokenType.OPERATION;
	}
	
	@Override
	public Token[] getSons() {
		return new Token[]{firstOperand, secondOperand};
	}

	@Override
	public void setSon(Token... sons) {		
		firstOperand = (sons[0] != null) ? firstOperand = sons[0] : firstOperand;
		secondOperand = (sons[1] != null) ? secondOperand = sons[1] : secondOperand;
		
		if(sons[0] != null) sons[0].setParent(this);

		if(sons[1] != null) sons[1].setParent(this);

	}
}
