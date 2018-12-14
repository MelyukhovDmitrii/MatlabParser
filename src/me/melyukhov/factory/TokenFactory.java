package me.melyukhov.factory;

import java.util.HashMap;
import java.util.Map;

import me.melyukhov.tokens.Token;

public class TokenFactory {
	private final static Map<TokenType, ITokenFactory<Token, Object>> REGISTRY = new HashMap<>();
	
	static {
		REGISTRY.put(TokenType.DISP, FactoryRegistry.DISP_FACTORY);
		REGISTRY.put(TokenType.FUNCTION, FactoryRegistry.FUNCTION_FACTORY);
		REGISTRY.put(TokenType.FUNCTION_NAME, FactoryRegistry.FUNCTION_NAME_FACTORY);
		REGISTRY.put(TokenType.OPERATION, FactoryRegistry.OPERATION_FACTORY);
		REGISTRY.put(TokenType.STRING, FactoryRegistry.STRING_TOKEN_FACTORY);
		REGISTRY.put(TokenType.VARIABLE, FactoryRegistry.VARIABLE_FACTORY);
		REGISTRY.put(TokenType.VALUE, FactoryRegistry.VALUE_FACTORY);
	}
	
	public static Token make(TokenType type, Object... data) {
		return REGISTRY.get(type).build(data);
	}
}
