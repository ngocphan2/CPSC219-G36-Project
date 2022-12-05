package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ExpensesController {
	private Stage primaryStage;
	private Scene myScene;
	private BudgetAppController nextController;
	private String validChecker;
	
	private double monthlySavings;

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
		nextController.setErrorExpensesLabels("");
	}
	
	public void setErrorLabel(String aString) {
		errorLabel.setText(aString);
	}
	
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}
	
	public void goToController(ActionEvent event) {
		nextController.takeFocus();
	}
}
