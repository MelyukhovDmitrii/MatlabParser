package me.melyukhov.tokens;

import me.melyukhov.factory.TokenType;

public class Function implements Token{

	private String name;
	private Token parent;
	private Token[] sons= new Token[0];
	
	public Function() {
		 
	}
	
	public Function(String name) {
		this.setName(name);
	}
	
	public Function(String name, Token parent) {
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
		return null;
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
		
	}

	@Override
	public TokenType getType() {
		return TokenType.FUNCTION;
	}

	@Override
	public void addSon(Token son) {
		Token[] def = this.sons.clone();
		this.sons = new Token[def.length+1];
		for(int i = 0; i < def.length; i++) {
			this.sons[i] = def[i];
		}
		this.sons[this.sons.length-1] = son;
		if(son != null)	son.setParent(this);
		
	}
	
}
