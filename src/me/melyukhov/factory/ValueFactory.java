package me.melyukhov.factory;

import me.melyukhov.tokens.Token;
import me.melyukhov.tokens.Value;

public class ValueFactory implements ITokenFactory<Token, Object>{

	@Override
	public Value build(Object... data) {
		switch(data.length) {
		case 0: return new Value();
		case 1: return new Value((String)data[0]);
		case 2: return new Value((String)data[0], (Token)data[1]);
		default: return null;
		}
	}

}
