package application;

public class Budget {
	private double value;
	
	Budget(double value) {
		this.value = value;
	}
	
	Budget(String value) throws InvalidBudgetException {	
		boolean validGrade = false;
		int counter = 0;
		
		if (!value.isBlank()) {
			validGrade = true;
		} else {
			throw new InvalidBudgetException("Please enter a value");
		}
		
		for (char c : value.toCharArray()) {
			if (Character.isDigit(c) || c == '.') {
				validGrade = true;
				if (c == '.') {
					counter++;
				}
			} else {
				throw new InvalidBudgetException("Do not use " + c + " in a budget value. Make sure to enter a number.");
			}
			
			if (counter > 1) {
				validGrade = false;
				throw new InvalidBudgetException("Cannot exceed more than 1 '.' in math");
			}
		}
		if (validGrade) {
			this.value = Double.parseDouble(value);
		}
	}
	
	double getValue() {
		return value;
	}
}
