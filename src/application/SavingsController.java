package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsController {
	private Stage primaryStage;
	private Scene myScene;
	private BudgetAppController nextController;
	private String validChecker;
	
	private double monthlySavings;
	private ArrayList<TextField> savingsTextFields = new ArrayList<TextField>();

	@FXML
	private Label errorLabel;
	
	@FXML
	private VBox savingsVBox;
	
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}	
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	public void setNextController(BudgetAppController next) {
		nextController = next;
		nextController.setErrorSavingsLabels("");
	}
	
	public void setErrorLabel(String aString) {
		errorLabel.setText(aString);
	}
	
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}
	
	public void goToController(ActionEvent event) {
		getAccumulation(savingsTextFields);
		
		if (validChecker != null)
			if (validChecker.equals("valid")) {
				nextController.takeFocus();
				nextController.setMonthlySavingsLabels("Monthly Savings is: $" + monthlySavings);
			}
	}
	
	public void addTextField(ActionEvent event) {
		savingsVBox.getChildren().addAll(Accumulation.generateTextField(savingsTextFields));
	}
	
	public void getAccumulation(ArrayList<TextField> savingsTextFields) {	
		monthlySavings = 0.0;
		try {
			for(TextField savingsTextField : savingsTextFields) {
				Accumulation savingsBudget = new Accumulation(savingsTextField.getText());
				monthlySavings += savingsBudget.getValue();
				validChecker = "valid";
			}			
		}
		catch (InvalidBudgetException ibe) {
			errorLabel.setText(ibe.getMessage());
			Accumulation savingsBudget = new Accumulation(0);
			monthlySavings += savingsBudget.getValue();
			validChecker = "invalid";
		}
	}
}
