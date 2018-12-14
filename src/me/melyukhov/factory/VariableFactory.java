package me.melyukhov.factory;

import me.melyukhov.tokens.Token;
import me.melyukhov.tokens.Variable;

public class VariableFactory implements ITokenFactory<Token, Object>{

	@Override
	public Variable build(Object... data) {
		switch(data.length) {
		case 0: return new Variable();
		case 1: return new Variable((String)data[0]);
		case 2: return new Variable((String)data[0], (Token)data[1]);
		default: return null;
		}
	}

}
