package me.melyukhov.factory;

import me.melyukhov.tokens.Token;

public interface ITokenFactory<T extends Token, D> {
	
	public T build(D... data);
	
}
