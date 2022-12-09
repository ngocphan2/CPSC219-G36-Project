package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * IncomeController class enables user to input their income data and go back to the main scene.
 * 
 * @author Henry Pham & Naomi Phan
 *
 */
public class IncomeController {
	//Declare instance variables pertaining to the GUI
	private Stage primaryStage;
	private Scene myScene;
	private BudgetAppController nextController;
	private String validChecker;
	
	//Declare instance variables pertaining to user's data input
	private double monthlyIncome;
	private ArrayList<TextField> incomeTextFields = new ArrayList<TextField>();
	
	//Import variable names from FXML file 
	@FXML
	private TextField employmentIncomeTextField;
	
	@FXML
	private TextField sideIncomeTextField;
	
	@FXML
	private TextField otherIncomeTextField;
	
	@FXML
	private Label errorLabel;
	
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
	 * for method setErrorIncomeLabel from nextController.
	 * 
	 * @param next Parameter of type BudgetAppController
	 */
	public void setNextController(BudgetAppController next) {
		nextController = next;
		nextController.setErrorIncomeLabels("");
	}
	
	/**
	 * This method set the value of errorLabel to aString and adds the 
	 * created TextFields to incomeTextFields.
	 * 
	 * @param aString Parameter of typer String
	 */
	public void setErrorLabel(String aString) {
		errorLabel.setText(aString);
		incomeTextFields.add(employmentIncomeTextField);
		incomeTextFields.add(sideIncomeTextField);
		incomeTextFields.add(otherIncomeTextField);
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
		getAccumulation(incomeTextFields);
		
		//Executes the following code if condition is met
		if (validChecker != null)
		if (validChecker.equals("valid")) {
			//Return to main Controller scene 
			nextController.takeFocus();
			//Set label
			nextController.setMonthlyIncomeLabels("Total Income: $" 
			+ String.format("%.2f", monthlyIncome));
			//Return monthlyIncome value to main Controller
			nextController.setIncomeValue(monthlyIncome);
		}
	}
	
	/**
	 * This method checks for the validity of user's data input and return an error message if 
	 * detected any error
	 * 
	 * @param incomeTextFields Parameter of type ArrayList<TextField>
	 */
	public void getAccumulation(ArrayList<TextField> incomeTextFields) {	
		//Initialize variable value
		monthlyIncome = 0.0;
		//Surround code with try/catch to handle errors
		try {
			//Check the validity of each TextField in incomeTextFields by calling for class Accumulation 
			for(TextField incomeTextField : incomeTextFields) {
				Accumulation incomeBudget = new Accumulation(incomeTextField.getText());
				monthlyIncome += incomeBudget.getValue();
				//Set validChecker value "valid" if no error caught
				validChecker = "valid";
			}			
		}
		catch (InvalidBudgetException ibe) {
			//Set error label to a certain text depends on the error
			errorLabel.setText(ibe.getMessage());
			//Set the value to 0
			Accumulation incomeBudget = new Accumulation(0);
			monthlyIncome += incomeBudget.getValue();
			//Set validChecker value to "invalid"
			validChecker = "invalid";
		}
	}	
}
