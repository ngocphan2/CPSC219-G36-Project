package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
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
	private ChoiceBox<String> activityChoiceBox = new ChoiceBox<String>();
	private ArrayList<Double> activityList = new ArrayList<Double>();


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
	
	public void getArrayTextField(ArrayList<TextField> arrayTextField) {
		savingsTextFields = arrayTextField;		
	}
	
	public void goToController(ActionEvent event) {
		getAccumulation(savingsTextFields);
		
		if (validChecker != null)
			if (validChecker.equals("valid")) {
				nextController.takeFocus();
				nextController.setMonthlySavingsLabels("Monthly Savings is: $" + monthlySavings);
				nextController.setSavingsValue(monthlySavings);
			}
	}
	
	public void addTextField(ActionEvent event) {
		savingsVBox.getChildren().addAll(Accumulation.generateTextField(savingsTextFields));
	}
	
	public void removeItem(ActionEvent event) {
		errorLabel.setText("");
		try {
			Accumulation.removeTextField(savingsVBox, savingsVBox.getChildren().size() - 1, savingsTextFields);
		}
		catch (IndexOutOfBoundsException e) {
			errorLabel.setText("There is no item left to remove.");
		}
	}
	
	public void getAccumulation(ArrayList<TextField> savingsTextFields) {	
		monthlySavings = 0.0;
		try {
			for(TextField savingsTextField : savingsTextFields) {
				Accumulation savingsAccumulaion = new Accumulation(savingsTextField.getText());
				monthlySavings += savingsAccumulaion.getValue();
				savingsAccumulaion.addChoiceBox(activityChoiceBox, savingsAccumulaion, activityList);
				validChecker = "valid";
			}			
		}
		catch (InvalidBudgetException ibe) {
			errorLabel.setText(ibe.getMessage());
			Accumulation savingsAccumulaion = new Accumulation(0);
			monthlySavings += savingsAccumulaion.getValue();
			validChecker = "invalid";
		}
	}
}
