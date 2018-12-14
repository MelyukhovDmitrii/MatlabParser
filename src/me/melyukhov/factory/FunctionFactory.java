package me.melyukhov.factory;

import me.melyukhov.tokens.Function;
import me.melyukhov.tokens.Token;

public class FunctionFactory implements ITokenFactory<Token, Object>{

	@Override
	public Function build(Object... data) {
		switch(data.length) {
		case 0: return new Function();
		case 1: return new Function((String)data[0]);
		case 2: return new Function((String)data[0], (Token)data[1]);
		default: return null;
		}
	}

}
