package me.melyukhov.factory;

import me.melyukhov.tokens.FunctionName;
import me.melyukhov.tokens.Token;

public class FunctionNameFactory implements ITokenFactory<Token, Object>{

	@Override
	public FunctionName build(Object... data) {
		switch(data.length) {
		case 0: return new FunctionName();
		case 1: return new FunctionName((String)data[0]);
		case 2: return new FunctionName((String)data[0], (Token)data[1]);
		default: return null;
		}
	}
}