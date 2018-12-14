package me.melyukhov.factory;

import me.melyukhov.tokens.Disp;
import me.melyukhov.tokens.Token;

public class DispFactory implements ITokenFactory<Token, Object>{

	@Override
	public Disp build(Object... data) {
		switch(data.length) {
		case 0: return new Disp();
		case 1: return new Disp((String)data[0]);
		case 2: return new Disp((String)data[0], (Token)data[1]);
		default: return null;
		}
	}

}
