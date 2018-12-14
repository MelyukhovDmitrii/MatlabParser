package me.melyukhov.factory;

import me.melyukhov.tokens.Operation;
import me.melyukhov.tokens.Token;

public class OperationFactory implements ITokenFactory<Token, Object>{

	@Override
	public Operation build(Object... data) {
		switch(data.length) {
		case 0: return new Operation();
		case 1: return new Operation((String)data[0]);
		case 2: return new Operation((String)data[0], (Token)data[1]);
		case 3: return new Operation((String)data[0], (Token)data[1], (Token)data[2]);
		case 4: return new Operation((String)data[0], (Token)data[1], (Token)data[2], (Token)data[3]);
		default: return null;
		}
	}

}
