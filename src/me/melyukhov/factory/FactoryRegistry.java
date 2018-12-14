package me.melyukhov.factory;

public class FactoryRegistry {
	public final static DispFactory DISP_FACTORY = new DispFactory();
	public final static FunctionFactory FUNCTION_FACTORY = new FunctionFactory();
	public final static FunctionNameFactory FUNCTION_NAME_FACTORY = new FunctionNameFactory();
	public final static OperationFactory OPERATION_FACTORY = new OperationFactory();
	public final static StringTokenFactory STRING_TOKEN_FACTORY = new StringTokenFactory();
	public final static VariableFactory VARIABLE_FACTORY = new VariableFactory();
	public final static ValueFactory VALUE_FACTORY = new ValueFactory();
}
