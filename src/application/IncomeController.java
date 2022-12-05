package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IncomeController {
	private Stage primaryStage;
	private Scene myScene;
	private BudgetAppController nextController;
	private String validChecker;
	
	private double monthlyIncome;
	private ArrayList<TextField> incomeTextFields = new ArrayList<TextField>();
	
	@FXML
	private TextField employmentIncomeTextField;
	
	@FXML
	private TextField sideIncomeTextField;
	
	@FXML
	private TextField otherIncomeTextField;
	
	@FXML
	private Label errorLabel;
	
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}	
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	public void setNextController(BudgetAppController next) {
		nextController = next;
		nextController.setErrorIncomeLabels("");
	}
	public void setErrorLabel(String aString) {
		errorLabel.setText(aString);
		incomeTextFields.add(employmentIncomeTextField);
		incomeTextFields.add(sideIncomeTextField);
		incomeTextFields.add(otherIncomeTextField);
	}
	
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}
	
	public void goToController(ActionEvent event) {
		
		getAccumulation(incomeTextFields);
		
		if (validChecker != null)
		if (validChecker.equals("valid")) {
			nextController.takeFocus();
			nextController.setMonthlyIncomeLabels("Monthly Income is: $" + monthlyIncome);
		}
	}
	
	public void getAccumulation(ArrayList<TextField> incomeTextFields) {	
		monthlyIncome = 0.0;
		try {
			for(TextField incomeTextField : incomeTextFields) {
				Accumulation incomeBudget = new Accumulation(incomeTextField.getText());
				monthlyIncome += incomeBudget.getValue();
				validChecker = "valid";
			}			
		}
		catch (InvalidBudgetException ibe) {
			errorLabel.setText(ibe.getMessage());
			Accumulation incomeBudget = new Accumulation(0);
			monthlyIncome += incomeBudget.getValue();
			validChecker = "invalid";
		}
	}
	
}
