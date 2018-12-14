package me.melyukhov.factory;

import me.melyukhov.tokens.StringToken;
import me.melyukhov.tokens.Token;

public class StringTokenFactory implements ITokenFactory<Token, Object>{

	@Override
	public Token build(Object... data) {
		switch(data.length) {
		case 0: return new StringToken();
		case 1: return new StringToken((String)data[0]);
		case 2: return new StringToken((String)data[0], (Token)data[1]);
		default: return null;
		}
	}

}
