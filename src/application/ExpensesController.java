package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * ExpensesController class enables user to input their expense data and go back to the main scene.
 * 
 * @author Henry Pham & Naomi Phan
 *
 */
public class ExpensesController {
	//Declare instance variables pertaining to the GUI
	private Stage primaryStage;
	private Scene myScene;
	private BudgetAppController nextController;
	private String validChecker;
	
	//Declare instance variables pertaining to user's data input
	private double monthlyExpenses;
	private ArrayList<TextField> expensesTextFields = new ArrayList<TextField>();

	//Import variable names from FXML file
	@FXML
	private Label errorLabel;
	
	@FXML
	private VBox expensesVBox;
	
	/**
	 * This method sets value of instance variable primaryStage
	 * 
	 * @param aStage Parameter of type Stage
	 */
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}	
	
	/**
	 * This method sets value of instance variable myScene
	 * 
	 * @param aScene Parameter of type Scene
	 */
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	
	/**
	 * This method set the value of nextController to variable next and call
	 * for method setErrorExpensesLabel from nextController.
	 * 
	 * @param next Parameter of type BudgetAppController
	 */
	public void setNextController(BudgetAppController next) {
		nextController = next;
		nextController.setErrorExpensesLabels("");
	}
	
	/**
	 * This method set the value of errorLabel to aString
	 * 
	 * @param aString Parameter of typer String
	 */
	public void setErrorLabel(String aString) {
		errorLabel.setText(aString);
	}
	
	/**
	 * This method set the scene of the user interface when called
	 */
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}
	
	/**
	 * This method calls getAccumulation and check for the validity to
	 * go back to the main Controller.
	 * 
	 * @param event Parameter of type ActionEvent
	 */
	public void goToController(ActionEvent event) {
		getAccumulation(expensesTextFields);
		
		//Executes the following code if condition is met
		if (validChecker != null)
			if (validChecker.equals("valid")) {
				//Return to main Controller scene 
				nextController.takeFocus();
				//Set label
				nextController.setMonthlyExpensesLabels("Total Expenses: $" 
				+ String.format("%.2f", monthlyExpenses));	
				//Return monthlyIncome value to main Controller
				nextController.setExpensesValue(monthlyExpenses);
			}
		}
	
	/**
	 * This method adds a new TextField to expensesVBox 
	 * 
	 * @param event Parameter of type ActionEvent
	 */
	public void addTextField(ActionEvent event) {
		errorLabel.setText("");
		expensesVBox.getChildren().addAll(Accumulation.generateTextField(expensesTextFields));
	}
	
	/**
	 * This method removes the last item from expensesVBox
	 * 
	 * @param event Parameter of type ActionEvent
	 */
	public void removeTextField(ActionEvent event) {
		errorLabel.setText("");
		try {
			Accumulation.removeTextField(expensesVBox, expensesVBox.getChildren().size() - 1, expensesTextFields);			
		}
		catch (IndexOutOfBoundsException e) {
			errorLabel.setText("There is no item left to remove.");
		}
	}
	
	/**
	 * This method checks for the validity of user's data input and return an error message if 
	 * detected any error
	 * 
	 * @param expensesTextFields Parameter of type ArrayList<TextField>
	 */
	public void getAccumulation(ArrayList<TextField> expensesTextFields) {	
		//Initialize variable value
		monthlyExpenses = 0.0;
		//Surround code with try/catch to handle errors
		try {
			//Check the validity of each TextField in expensesTextFields by calling for class Accumulation
			for(TextField expensesTextField : expensesTextFields) {
				Accumulation expensesAccumulation = new Accumulation(expensesTextField.getText());
				monthlyExpenses += expensesAccumulation.getValue();
				//Set validChecker value "valid" if no error caught
				validChecker = "valid";
			}			
		}
		catch (InvalidBudgetException ibe) {
			//Set error label to a certain text depends on the error
			errorLabel.setText(ibe.getMessage());
			//Set the value to 0
			Accumulation expensesAccumulation = new Accumulation(0);
			monthlyExpenses += expensesAccumulation.getValue();
			//Set validChecker value to "invalid"
			validChecker = "invalid";
		}
	}
}
