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
 * SavingsController class enables user to input their saving data and go back to the main scene.
 * 
 * @author Henry Pham & Naomi Phan
 *
 */
public class SavingsController {
	//Declare instance variables pertaining to the GUI
	private Stage primaryStage;
	private Scene myScene;
	private BudgetAppController nextController;
	private String validChecker;
	
	//Declare instance variables pertaining to user's data input
	private double monthlySavings;
	private ArrayList<TextField> savingsTextFields = new ArrayList<TextField>();

	//Import variable names from FXML file
	@FXML
	private Label errorLabel;
	
	@FXML
	private VBox savingsVBox;
	
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
	 * for method setErrorSavingsLabel from nextController.
	 * 
	 * @param next Parameter of type BudgetAppController
	 */
	public void setNextController(BudgetAppController next) {
		nextController = next;
		nextController.setErrorSavingsLabels("");
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
		getAccumulation(savingsTextFields);
		
		//Executes the following code if condition is met
		if (validChecker != null)
			if (validChecker.equals("valid")) {
				//Return to main Controller scene 
				nextController.takeFocus();
				//Set label
				nextController.setMonthlySavingsLabels("Total Spending Budget: $" 
				+ String.format("%.2f", monthlySavings));
				//Return monthlyIncome value to main Controller
				nextController.setSavingsValue(monthlySavings);
			}
	}
	
	/**
	 * This method adds a new TextField to savingsVBox 
	 * 
	 * @param event Parameter of type ActionEvent
	 */
	public void addTextField(ActionEvent event) {
		savingsVBox.getChildren().addAll(Accumulation.generateTextField(savingsTextFields));
	}
	
	/**
	 * This method removes the last item from savingsVbox
	 * 
	 * @param event Parameter of type ActionEvent
	 */
	public void removeItem(ActionEvent event) {
		errorLabel.setText("");
		try {
			Accumulation.removeTextField(savingsVBox, savingsVBox.getChildren().size() - 1, savingsTextFields);
		}
		catch (IndexOutOfBoundsException e) {
			errorLabel.setText("There is no item left to remove.");
		}
	}
	
	/**
	 * This method checks for the validity of user's data input and return an error message if 
	 * detected any error
	 * 
	 * @param savingsTextFields Parameter of type ArrayList<TextField>
	 */
	public void getAccumulation(ArrayList<TextField> savingsTextFields) {	
		//Initialize variable value
		monthlySavings = 0.0;
		//Surround code with try/catch to handle errors
		try {
			//Check the validity of each TextField in savingsTextFields by calling for class Accumulation
			for(TextField savingsTextField : savingsTextFields) {
				Accumulation savingsAccumulaion = new Accumulation(savingsTextField.getText());
				monthlySavings += savingsAccumulaion.getValue();
				//Set validChecker value "valid" if no error caught
				validChecker = "valid";
			}			
		}
		catch (InvalidBudgetException ibe) {
			//Set error label to a certain text depends on the error
			errorLabel.setText(ibe.getMessage());
			//Set the value to 0
			Accumulation savingsAccumulaion = new Accumulation(0);
			monthlySavings += savingsAccumulaion.getValue();
			//Set validChecker value to "invalid"
			validChecker = "invalid";
		}
	}
}
