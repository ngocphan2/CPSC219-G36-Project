package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
	private TextField expensesTextField;
	private double monthlyIncome = 0.0;
	private double monthlyBudget = 0.0;
	private double monthlyExpenses = 0.0;
	


	@FXML
	private Label errorIncomeLabel;
	
	@FXML
	private Label errorBudgetLabel;
	
	@FXML
	private Label errorExpensesLabel;
	
	@FXML
	private Label monthlyIncomeLabel;
	
	@FXML
	private Label monthlyBudgetLabel;

	@FXML
	private Label monthlyExpensesLabel;	
	
	public void calculateIncome(Scene mainScene, ArrayList<TextField> incomeTextFields) {
		monthlyIncome = 0.0;
		errorIncomeLabel.setText("");
		String validChecker = "valid";
		
		try {
			for(TextField incomeTextField : incomeTextFields) {
				Budget incomeBudget = new Budget(incomeTextField.getText());
				monthlyIncome += incomeBudget.getValue();
			}			
		}
		catch (InvalidBudgetException ibe) {
			errorIncomeLabel.setText(ibe.getMessage()); 
			Budget incomeBudget = new Budget(0);
			monthlyIncome += incomeBudget.getValue();
			validChecker = "invalid";
		}
		
		monthlyIncomeLabel.setText("Total income is: $" + monthlyIncome);
		
		if (validChecker.equals("valid"))	applicationStage.setScene(mainScene);		
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
    	doneButton.setOnAction(doneEvent -> calculateIncome(mainScene, incomeTextFields));
    	incomeContainer.getChildren().addAll(doneButton);
		
		Scene incomeScene = new Scene(incomeContainer);
		applicationStage.setScene(incomeScene);
	}
	
	public void calculateBudget(Scene mainScene, ArrayList<TextField> budgetTextFields) {
		monthlyBudget = 0.0;
		errorBudgetLabel.setText("");
		String validChecker = "valid";
		
		try {
			for(TextField budgetTextField : budgetTextFields) {
				Budget budgetBudget = new Budget(budgetTextField.getText());
				monthlyBudget += budgetBudget.getValue();
			}			
		}
		catch (InvalidBudgetException ibe) {
			errorBudgetLabel.setText(ibe.getMessage()); 
			Budget budgetBudget = new Budget(0);
			monthlyBudget += budgetBudget.getValue();
			validChecker = "invalid";
		}
		
		monthlyBudgetLabel.setText("Total budget is: $" + monthlyBudget);
		
		if (validChecker.equals("valid"))	applicationStage.setScene(mainScene);		
	}
	
	@FXML
	void getBudget(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		VBox budgetContainer = new VBox();

		ArrayList<TextField> budgetTextFields = new ArrayList<TextField>();
		BorderPane expensesBorderPane = new BorderPane();
		Label budgetTitleLabel = new Label("Monthly Budget");
		Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateBudget(mainScene, budgetTextFields));

    	expensesBorderPane.setCenter(budgetTitleLabel);
    	expensesBorderPane.setRight(doneButton);
    	budgetContainer.getChildren().addAll(expensesBorderPane, errorBudgetLabel);				

    	Button addBudgetButton = new Button("Add more");
		addBudgetButton.setOnAction(doneEvent -> {budgetContainer.getChildren().addAll(generateTextField());
		budgetTextFields.add(expensesTextField);});
		budgetContainer.getChildren().add(addBudgetButton);

		Scene budgetScene = new Scene(budgetContainer);
		applicationStage.setScene(budgetScene);
	}
	
	BorderPane generateDate() {
		DatePicker addDate = new DatePicker();
		BorderPane newDate = new BorderPane();
		newDate.setLeft(addDate);
		return newDate;
	}

	BorderPane generateTextField() {
		ChoiceBox<String> activityChoiceBox = new ChoiceBox<String>();
    	activityChoiceBox.setValue("Select Activity");
    	ObservableList<String> activityList = activityChoiceBox.getItems();
    	activityList.add("Rent/Mortgage");
    	activityList.add("Car Payment");
    	activityList.add("Car Insurance");
    	activityList.add("Health Insurance");
    	activityList.add("Other Insurance");
    	activityList.add("Food");
    	activityList.add("Utility");
    	activityList.add("Phone Bill");
    	activityList.add("Miscenllaneous");
    	activityList.add("Shopping");
    	activityList.add("Household Necessities");
    	activityList.add("Other");
		expensesTextField = new TextField();
		BorderPane expensesBorderPane = new BorderPane();

		expensesBorderPane.setLeft(activityChoiceBox);
		expensesBorderPane.setRight(expensesTextField);
		
		return expensesBorderPane;
	}
	
	
	
	public void calculateExpenses(Scene mainScene) {
		errorExpensesLabel.setText("");
		String validChecker = "valid";
		
		
		if (validChecker.equals("valid"))	applicationStage.setScene(mainScene);
	}
	
	@FXML
	void getExpenses(ActionEvent expensesEvent) {
		Scene mainScene = applicationStage.getScene();
		
		VBox expensesContainer = new VBox();
		
		BorderPane expensesBorderPane1 = new BorderPane();
		BorderPane expensesBorderPane2 = new BorderPane();
		Label expensesTitleLabel = new Label("Monthly Expenses");
		Button doneButton = new Button("Done");
    	doneButton.setOnAction(doneEvent -> calculateExpenses(mainScene));
		DatePicker myDate = new DatePicker();
		
		Button addExpenseButton = new Button("Add More Activities");
		addExpenseButton.setOnAction(doneEvent -> expensesContainer.getChildren().addAll(generateTextField()));
		
		Button addDateButton = new Button ("Select Another Date");
		addDateButton.setOnAction(doneEvent -> expensesContainer.getChildren().add(generateDate()));
		
		expensesBorderPane1.setCenter(expensesTitleLabel);
		expensesBorderPane1.setRight(doneButton);
		expensesBorderPane2.setLeft(addExpenseButton);
		expensesBorderPane2.setCenter(addDateButton );
		expensesContainer.getChildren().addAll(expensesBorderPane1, expensesBorderPane2, errorExpensesLabel);

				
    	expensesContainer.getChildren().add(myDate);
    	
//    	ChoiceBox<String> expenseActivityChoiceBox = new ChoiceBox<String>();
//    	expenseActivityChoiceBox.setValue("Select Activity");
//    	ObservableList<String> activityList = expenseActivityChoiceBox.getItems();
//    	activityList.add("Rent/Mortgage");
//    	activityList.add("Car Payment");
//    	activityList.add("Car Insurance");
//    	activityList.add("Health Insurance");
//    	activityList.add("Other Insurance");
//    	activityList.add("Food");
//    	activityList.add("Utility");
//    	activityList.add("Phone Bill");
//    	activityList.add("Miscenllaneous");
//    	activityList.add("Shopping");
//    	activityList.add("Household Necessities");
//    	activityList.add("Other");
//    	
//		TextField expensesTextField = new TextField("Enter expense amount");
//		BorderPane expensesBorderPane3 = new BorderPane();
//		
//		expensesBorderPane3.setLeft(expenseActivityChoiceBox);
//		expensesBorderPane3.setRight(expensesTextField);
//		expensesContainer.getChildren().addAll(expensesBorderPane3);		
		
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