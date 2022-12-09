package application;

/**
 * Budget class is an abstract class that defines fundamentals for its children classes
 * 
 * @author Henry Pham & Naomi Phan
 *
 */
public abstract class Budget {
	private double value;
	
	/**
	 * This constructor takes in a double sets the value to the instance variable value.
	 * 
	 * @param value Parameter of type value to Budget constructor
	 */
	public Budget(double value) {
		this.value = value;
	}
	
	/**
	 * This constructor takes in a String and checks for any error existed then adjust
	 * the value of that String to a double if the boolean variable validGrade holds true.
	 * Throw an error otherwise. 
	 * 
	 * @param value Parameter of type String to Budget constructor
	 * @throws InvalidBudgetException On input error from InvalidBudgetException class 
	 */
	public Budget(String str) throws InvalidBudgetException {	
		//Instantiate local variables
		boolean validGrade = false;
		int counter = 0;
		
		//Checks if String value is blank
		if (!str.isBlank()) {
			validGrade = true;
		} else {
			throw new InvalidBudgetException("Please enter a value");
		}
		
		//for-loop checking each character of String value
		for (char c : str.toCharArray()) {
			//Check if character fits either a period or a digit 
			if (Character.isDigit(c) || c == '.') {
				validGrade = true;
				//Check again if character is a period
				if (c == '.') {
					counter++;
				}
			} else {
				throw new InvalidBudgetException("Do not use '" + c + "' in a budget value. Make sure to enter a number.");
			}
			
			//Check if there were more than 1 periods within 1 String value
			if (counter > 1) {
				validGrade = false;
				throw new InvalidBudgetException("Cannot exceed more than 1 '.' in math");
			}
		}
		//Check if boolean validGrade holds true or not
		if (validGrade) {
			this.value = Double.parseDouble(str);
		}
	}
	
	/**
	 * This method returns the value of instance variable value without making any adjustment to it.
	 * 
	 * @return value This returns the value of the instance variable value
	 */
	public double getValue() {
		return value;
	}
}
