package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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

		Label incomeTitleLabel = new Label("Monthly Income");
		ArrayList<TextField> incomeTextFields = new ArrayList<TextField>();
		incomeContainer.getChildren().addAll(incomeTitleLabel, errorIncomeLabel);
		
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
		
		BorderPane expensesBorderPane = new BorderPane();
		Label budgetTitleLabel = new Label("Monthly Budget");
		Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateBudget(mainScene));

    	expensesBorderPane.setCenter(budgetTitleLabel);
    	expensesBorderPane.setRight(doneButton);
    	budgetContainer.getChildren().addAll(expensesBorderPane, errorBudgetLabel);				
		
    	Button addBudgetButton = new Button("Add more");
		addBudgetButton.setOnAction(doneEvent -> budgetContainer.getChildren().addAll(generateTextField()));
		budgetContainer.getChildren().add(addBudgetButton);
		
		Scene budgetScene = new Scene(budgetContainer);
		applicationStage.setScene(budgetScene);
	}

	BorderPane generateTextField() {
		TextField expenseActivityTextField = new TextField("Enter activity");
		TextField expensesTextField = new TextField("Enter amount");
		BorderPane expensesBorderPane = new BorderPane();
		
		expensesBorderPane.setCenter(expenseActivityTextField);
		expensesBorderPane.setRight(expensesTextField);

		return expensesBorderPane;
	}
	
	public void calculateExpenses(Scene mainScene) {
		errorExpensesLabel.setText("");
		applicationStage.setScene(mainScene);
	}

	@FXML
	void getExpenses(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		VBox expensesContainer = new VBox();

		BorderPane expensesBorderPane1 = new BorderPane();
		BorderPane expensesBorderPane2 = new BorderPane();
		Label expensesTitleLabel = new Label("Monthly Expenses" + '\n' + "Please select a date");
		Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateExpenses(mainScene));
		DatePicker myDate = new DatePicker();
		
		expensesBorderPane1.setCenter(expensesTitleLabel);
		expensesBorderPane1.setRight(doneButton);
		expensesBorderPane2.setCenter(myDate);
		expensesContainer.getChildren().addAll(expensesBorderPane1, expensesBorderPane2, errorExpensesLabel);
		
		Button addExpenseButton = new Button("Add more");
		addExpenseButton.setOnAction(doneEvent -> expensesContainer.getChildren().addAll(generateTextField()));		
    	expensesContainer.getChildren().add(addExpenseButton);

		TextField expenseActivityTextField = new TextField("Enter expense activity");
		TextField expensesTextField = new TextField("Enter expense amount");
		BorderPane expensesBorderPane3 = new BorderPane();
		
		expensesBorderPane3.setCenter(expenseActivityTextField);
		expensesBorderPane3.setRight(expensesTextField);
		expensesContainer.getChildren().add(expensesBorderPane3);
		
		
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
