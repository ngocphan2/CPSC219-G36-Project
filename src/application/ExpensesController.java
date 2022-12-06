package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExpensesController {
	private Stage primaryStage;
	private Scene myScene;
	private BudgetAppController nextController;
	private String validChecker;
	
	private double monthlyExpenses;
	private ArrayList<TextField> expensesTextFields = new ArrayList<TextField>();


	@FXML
	private Label errorLabel;
	
	@FXML
	private VBox expensesVBox;
	
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}	
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	public void setNextController(BudgetAppController next) {
		nextController = next;
		nextController.setErrorExpensesLabels("");
	}
	
	public void setErrorLabel(String aString) {
		errorLabel.setText(aString);
	}
	
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}
	
	public void goToController(ActionEvent event) {
		getAccumulation(expensesTextFields);
		
		if (validChecker != null)
			if (validChecker.equals("valid")) {
				nextController.takeFocus();
				nextController.setMonthlyExpensesLabels("Monthly Savings is: $" + monthlyExpenses);
			}	}
	
	public void addTextField(ActionEvent event) {
		expensesVBox.getChildren().addAll(Accumulation.generateTextField(expensesTextFields));
	}
	
	public void addCalendar(ActionEvent event) {
		expensesVBox.getChildren().addAll(Accumulation.generateDate());
	}
	
	public void getAccumulation(ArrayList<TextField> expensesTextFields) {	
		monthlyExpenses = 0.0;
		try {
			for(TextField expensesTextField : expensesTextFields) {
				Accumulation expensesBudget = new Accumulation(expensesTextField.getText());
				monthlyExpenses += expensesBudget.getValue();
				validChecker = "valid";
			}			
		}
		catch (InvalidBudgetException ibe) {
			errorLabel.setText(ibe.getMessage());
			Accumulation expensesBudget = new Accumulation(0);
			monthlyExpenses += expensesBudget.getValue();
			validChecker = "invalid";
		}
	}
}
