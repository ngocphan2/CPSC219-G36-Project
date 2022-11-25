package application;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class BudgetAppController {
	public Stage applicationStage;

	public void calculateIncome(Scene mainScene) {
		applicationStage.setScene(mainScene);
	}
	
	@FXML
	void getIncome(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		VBox incomeContainer = new VBox();
		
		Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateIncome(mainScene));
    	incomeContainer.getChildren().addAll(doneButton);
		
		Scene incomeScene = new Scene(incomeContainer);
		applicationStage.setScene(incomeScene);
	}
	
	public void calculateBudget(Scene mainScene) {
		applicationStage.setScene(mainScene);
	}

	@FXML
	void getBudget(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		VBox incomeContainer = new VBox();
		
		Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateIncome(mainScene));
    	incomeContainer.getChildren().addAll(doneButton);
		
		Scene incomeScene = new Scene(incomeContainer);
		applicationStage.setScene(incomeScene);
	}

	public void calculateExpenses(Scene mainScene) {
		applicationStage.setScene(mainScene);
	}

	@FXML
	void getExpenses(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		VBox incomeContainer = new VBox();
		
		Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateIncome(mainScene));
    	incomeContainer.getChildren().addAll(doneButton);
		
		Scene incomeScene = new Scene(incomeContainer);
		applicationStage.setScene(incomeScene);
	}
	
	@FXML
	void insightChecker(ActionEvent event) {
		
	}
}
