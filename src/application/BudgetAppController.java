package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;


public class BudgetAppController {
	public Stage applicationStage;

	@FXML
	private Label errorIncomeLabel;
	
	@FXML
	private Label errorBudgetLabel;

	@FXML
	private Label errorExpensesLabel;
	
	public void calculateIncome(Scene mainScene) {
		errorIncomeLabel.setText("");
		applicationStage.setScene(mainScene);
		
	}
	
	@FXML
	void getIncome(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		ArrayList<String> incomeListLabels = new ArrayList<String>();
		VBox incomeContainer = new VBox();
		
		incomeListLabels.add("Employment Income");
		incomeListLabels.add("Side Income");
		incomeListLabels.add("Other Income");
		incomeContainer.getChildren().add(errorIncomeLabel);

		Label incomeTitleLabel = new Label("Monthly Income");
		ArrayList<TextField> incomeTextFields = new ArrayList<TextField>();
		incomeContainer.getChildren().addAll(incomeTitleLabel);
		
		for (int i = 0; i < incomeListLabels.size(); i++) {
			HBox rowContainer = new HBox();
			Label incomeLabel = new Label(incomeListLabels.get(i));
			TextField incomeTextField = new TextField();
			incomeTextFields.add(incomeTextField);
			
			rowContainer.getChildren().addAll(incomeLabel, incomeTextField);
			
			incomeContainer.getChildren().addAll(rowContainer);
		}
		
		Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateIncome(mainScene));
    	incomeContainer.getChildren().addAll(doneButton);
		
		Scene incomeScene = new Scene(incomeContainer);
		applicationStage.setScene(incomeScene);
	}
	
	public void calculateBudget(Scene mainScene) {
		errorBudgetLabel.setText("");
		applicationStage.setScene(mainScene);
	}

	@FXML
	void getBudget(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		VBox budgetContainer = new VBox();
		
		budgetContainer.getChildren().add(errorBudgetLabel);
		
		Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateBudget(mainScene));
    	budgetContainer.getChildren().addAll(doneButton);
		
		Scene budgetScene = new Scene(budgetContainer);
		applicationStage.setScene(budgetScene);
	}

	public void calculateExpenses(Scene mainScene) {
		errorExpensesLabel.setText("");
		applicationStage.setScene(mainScene);
	}

	@FXML
	void getExpenses(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		VBox expensesContainer = new VBox();

		expensesContainer.getChildren().add(errorExpensesLabel);

		Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateExpenses(mainScene));
    	expensesContainer.getChildren().addAll(doneButton);
		
		Scene expensesScene = new Scene(expensesContainer);
		applicationStage.setScene(expensesScene);
	}
	
	public void checkInsight(Scene mainScene) {
		applicationStage.setScene(mainScene);
	}
	
	@FXML
	void insightChecker(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		VBox insightContainer = new VBox();
		
		Button doneButton = new Button("Redo");
    	doneButton.setOnAction(doneEvent -> checkInsight(mainScene));
    	insightContainer.getChildren().addAll(doneButton);
		
		Scene insightScene = new Scene(insightContainer);
		applicationStage.setScene(insightScene);
	}
}
