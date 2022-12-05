package application;

public class Accumulation extends Budget{

	public Accumulation(double value) {
		super(value);
	}
	
	public Accumulation(String str) throws InvalidBudgetException{
		super(str);
	}
}
