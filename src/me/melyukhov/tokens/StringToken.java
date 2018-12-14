package me.melyukhov.tokens;

import me.melyukhov.factory.TokenType;

public class StringToken implements Token {

	private String name = "";
	private Token parent;
	private Token[] sons = null;
	
	public StringToken() {
		
	}
	
	public StringToken(String name) {
		this.setName(name);
	}
	
	public StringToken(String name, Token parent) {
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
		return sons;
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
		this.sons = sons;
		if(sons != null) {
			for(Token i: sons) {
				i.setParent(this);
			}
		}
	}

	@Override
	public void addSon(Token son) {
		if(this.sons != null) {
			Token[] pastSons = this.sons.clone();
			this.sons = new Token[pastSons.length+1];
			for(int i = 0; i < pastSons.length; i++) {
				this.sons[i] = pastSons[i];
			}
			this.sons[this.sons.length-1] = son; 
		} else {
			this.sons = new Token[] { son };
			
		}
		son.setParent(this);
		/*this.sons = new Token[pastSons.length + sons.length];
		for(int i = 0; i < this.sons.length; i++) {
			if(i < pastSons.length) {
				this.sons[i] = pastSons[i];
			} else {
				this.sons[i] = sons[i-pastSons.length];
			}
		}*/
	}

	@Override
	public TokenType getType() {
		return TokenType.STRING;
	}
	
	
	
}
