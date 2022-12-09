package application;

/**
 * InvalidBudgetException enables other classes to call and throw any customize exception
 * 
 * @author Henry Pham & Naomi Phan
 *
 */
public class InvalidBudgetException extends Exception {

	/**
	 * Default constructor of InvalidBudgetException
	 */
	public InvalidBudgetException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This constructor calls for the same constructor with one parameter of type String 
	 * from class Extension
	 * 
	 * @param message Parameter of type String
	 */
	public InvalidBudgetException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This constructor calls for the same constructor with one parameter of type Throwable 
	 * from class Extension
	 * 
	 * @param cause Parameter of type Throwable
	 */
	public InvalidBudgetException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This constructor calls for the same constructor with 2 parameter of type String 
	 * and Throwable from class Extension
	 * 
	 * @param message First parameter to constructor InvalidBudgetException
	 * @param cause Second parameter to constructor InvalidBudgetException
	 */
	public InvalidBudgetException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This constructor calls for the same constructor with 4 parameter of type String, 
	 * Throwable, boolean and boolean from class Extension
	 * 
	 * @param message First parameter to constructor InvalidBudgetException
	 * @param cause Second parameter to constructor InvalidBudgetException
	 * @param enableSuppression Third parameter to constructor InvalidBudgetException
	 * @param writableStackTrace Fourth parameter to constructor InvalidBudgetException
	 */
	public InvalidBudgetException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
