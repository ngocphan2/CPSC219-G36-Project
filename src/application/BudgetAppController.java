package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class BudgetAppController {
	private Stage primaryStage;
	private Scene myScene;
	
	private IncomeController incomeSceneController;
	private SavingsController savingSceneController;
	private ExpensesController expensesSceneController;
	
	private TextField expensesTextField;
	private double monthlyIncome = 0.0;
	private double monthlySavings = 0.0;
	private double monthlyExpenses = 0.0;

	@FXML
	private Label errorIncomeLabel;
	
	@FXML
	private Label errorSavingsLabel;
	
	@FXML
	private Label errorExpensesLabel;
	
	@FXML
	private Label monthlyIncomeLabel;
	
	@FXML
	private Label monthlySavingsLabel;

	@FXML
	private Label monthlyExpensesLabel;	
	
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}	
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}
	
	public void setMonthlyIncomeLabels(String incomeStr) {
		monthlyIncomeLabel.setText(incomeStr);
	}
	public void setMonthlySavingsLabels(String SavingsStr) {
		monthlySavingsLabel.setText(SavingsStr);
	}
	public void setMonthlyExpensesLabels(String expensesStr) {
		monthlyExpensesLabel.setText(expensesStr);
	}
	
	public void setErrorIncomeLabels(String str) {
		errorIncomeLabel.setText(str);
	}
	public void setErrorSavingsLabels(String str) {
		errorSavingsLabel.setText(str);
	}
	public void setErrorExpensesLabels(String str) {
		errorExpensesLabel.setText(str);
	}
	
	@FXML
	public void getIncome(ActionEvent event) {
		if(incomeSceneController == null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(new FileInputStream("src/application/IncomeControllerView.fxml"));
				
				incomeSceneController = loader.getController();
				incomeSceneController.setPrimaryStage(primaryStage);
				incomeSceneController.setMyScene(new Scene(root));
				incomeSceneController.setNextController(this);
				incomeSceneController.setErrorLabel("");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		incomeSceneController.takeFocus();
	}
	
	@FXML
	public void getSavings(ActionEvent event) {
		if(savingSceneController == null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(new FileInputStream("src/application/SavingsControllerView.fxml"));
				
				savingSceneController = loader.getController();
				savingSceneController.setPrimaryStage(primaryStage);
				savingSceneController.setMyScene(new Scene(root));
				savingSceneController.setNextController(this);
				savingSceneController.setErrorLabel("");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		savingSceneController.takeFocus();
	}
	
	@FXML
	public void getExpenses(ActionEvent event) {
		if(expensesSceneController == null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(new FileInputStream("src/application/ExpensesControllerView.fxml"));
				
				expensesSceneController = loader.getController();
				expensesSceneController.setPrimaryStage(primaryStage);
				expensesSceneController.setMyScene(new Scene(root));
				expensesSceneController.setNextController(this);
				expensesSceneController.setErrorLabel("");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		expensesSceneController.takeFocus();
	}
	
	@FXML
	public void insightChecker(ActionEvent event) {
		
	}
//	public void calculateSavings(Scene mainScene, ArrayList<TextField> savingsTextFields) {
//		monthlySavings = 0.0;
//		errorSavingsLabel.setText("");
//		String validChecker = "valid";
//		
////		try {
////			for(TextField savingsTextField : savingsTextFields) {
////				Budget savingsBudget = new Budget(savingsTextField.getText());
////				monthlySavings+= savingsBudget.getValue();
////			}			
////		}
////		catch (InvalidBudgetException ibe) {
////			errorSavingsLabel.setText(ibe.getMessage()); 
////			Budget savingsBudget = new Budget(0);
////			monthlySavings += savingsBudget.getValue();
////			validChecker = "invalid";
////		}
//		
//		monthlySavingsLabel.setText("Total budget is: $" + monthlySavings);
//		
//		if (validChecker.equals("valid"))	applicationStage.setScene(mainScene);		
//	}
//	
//	@FXML
//	void getSavings(ActionEvent event) {
//		Scene mainScene = applicationStage.getScene();
//		VBox savingsContainer = new VBox();
//
//		ArrayList<TextField> savingsTextFields = new ArrayList<TextField>();
//		BorderPane savingsBorderPane = new BorderPane();
//		Label savingsTitleLabel = new Label("Monthly Budget");
//		Button doneButton = new Button("Done");
//    	doneButton.setOnAction(doneEvent -> calculateSavings(mainScene, savingsTextFields));
//
//    	savingsBorderPane.setCenter(savingsTitleLabel);
//    	savingsBorderPane.setRight(doneButton);
//    	savingsContainer.getChildren().addAll(savingsBorderPane, errorSavingsLabel);				
//
//    	Button addBudgetButton = new Button("Add more");
//		addBudgetButton.setOnAction(doneEvent -> {savingsContainer.getChildren().addAll(generateTextField());
//		savingsTextFields.add(expensesTextField);});
//		savingsContainer.getChildren().add(addBudgetButton);
//
//		Scene budgetScene = new Scene(savingsContainer);
//		applicationStage.setScene(budgetScene);
//	}
//	
//	BorderPane generateDate() {
//		DatePicker addDate = new DatePicker();
//		BorderPane newDate = new BorderPane();
//		addDate.getEditor().setDisable(true);
//		newDate.setLeft(addDate);
//		return newDate;
//	}
//
//	BorderPane generateTextField() {
//		ChoiceBox<String> activityChoiceBox = new ChoiceBox<String>();
//    	activityChoiceBox.setValue("Select Activity");
//    	ObservableList<String> activityList = activityChoiceBox.getItems();
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
//		expensesTextField = new TextField();
//		BorderPane expensesBorderPane = new BorderPane();
//
//		expensesBorderPane.setLeft(activityChoiceBox);
//		expensesBorderPane.setRight(expensesTextField);
//		
//		return expensesBorderPane;
//	}
//	
//	
//	
//	public void calculateExpenses(Scene mainScene, ArrayList<TextField> expensesTextFields) {
//		monthlyExpenses = 0.0;
//		errorExpensesLabel.setText("");
//		String validChecker = "valid";
//		
////		try {
////			for(TextField expensesTextField : expensesTextFields) {
////				Budget expensesBudget = new Budget(expensesTextField.getText());
////				monthlyExpenses += expensesBudget.getValue();
////			}			
////		}
////		catch (InvalidBudgetException ibe) {
////			errorExpensesLabel.setText(ibe.getMessage()); 
////			Budget expensesBudget = new Budget(0);
////			monthlyExpenses += expensesBudget.getValue();
////			validChecker = "invalid";
////		}
//		
//		monthlyExpensesLabel.setText("Total expenses is: $" + monthlyExpenses);
//		
//		if (validChecker.equals("valid"))	applicationStage.setScene(mainScene);
//	}
//	
//	@FXML
//	void getExpenses(ActionEvent expensesEvent) {
//		Scene mainScene = applicationStage.getScene();
//		
//		ScrollPane sp = new ScrollPane();
//		VBox expensesContainer = new VBox();
//		VBox tfContainer = new VBox();
//		
//		ArrayList<TextField> expensesTextFields = new ArrayList<TextField>();
//		BorderPane expensesBorderPane1 = new BorderPane();
//		BorderPane expensesBorderPane2 = new BorderPane();
//		Label expensesTitleLabel = new Label("Monthly Expenses");
//		Button doneButton = new Button("Done");
//    	doneButton.setOnAction(doneEvent -> calculateExpenses(mainScene, expensesTextFields));
//		DatePicker myDate = new DatePicker();
//		myDate.getEditor().setDisable(true);
//		
//		sp.setContent(tfContainer);
//		sp.setPannable(true);
//		Button addExpenseButton = new Button("Add More Activities");
//		addExpenseButton.setOnAction(doneEvent -> {tfContainer.getChildren().add(generateTextField());
//		expensesTextFields.add(expensesTextField);});
//		
//		
//		Button addDateButton = new Button ("Select Another Date");
//		addDateButton.setOnAction(doneEvent -> tfContainer.getChildren().add(generateDate()));
//		
//		expensesBorderPane1.setCenter(expensesTitleLabel);
//		expensesBorderPane1.setRight(doneButton);
//		expensesBorderPane2.setLeft(addExpenseButton);
//		expensesBorderPane2.setCenter(addDateButton );
//		expensesContainer.getChildren().addAll(expensesBorderPane1, expensesBorderPane2, 
//				errorExpensesLabel, myDate, sp);
//				    	
//		Scene expensesScene = new Scene(expensesContainer);
//		applicationStage.setScene(expensesScene);
//	}
//	
//	public void checkInsight(Scene mainScene) {
//		
//		
//		applicationStage.setScene(mainScene);
//	}
//	
//	@FXML
//	void insightChecker(ActionEvent event) {
//		Scene mainScene = applicationStage.getScene();
//		double Income = monthlyIncome - monthlyExpenses;
//
//		VBox insightContainer = new VBox();
//		
//		Label insightTitleLabel = new Label("Overview");
//		Label insightIncomeLabel = new Label("Total income: $" + Income
//				+ "\n(Revenue - Expenses)");
//		Label insightBudgetLabel = new Label("Target budget: $" + monthlySavings);
//		
//		
//		Label insightIncomeResultLabel = new Label();
//		if (Income > 0 ) insightIncomeResultLabel.setText("Saving is at a surplus of: $" + Income);
//		else if (Income < 0 ) insightIncomeResultLabel.setText("Saving is at a deficit of: $" + Income);
//		else if (Income == 0 ) insightIncomeResultLabel.setText("Saving is at $0");
//		
//		Label insightSavingResultLabel = new Label();
//		if (monthlySavings >= monthlyExpenses ) insightSavingResultLabel.setText("Budget target met");
//		else if (monthlySavings < monthlyExpenses ) insightSavingResultLabel.setText("Failed to meet Budget target");
//		
//		insightContainer.getChildren().addAll(insightTitleLabel, insightIncomeLabel, insightBudgetLabel, insightIncomeResultLabel, insightSavingResultLabel);
//		
//		Button doneButton = new Button("Redo");
//    	doneButton.setOnAction(doneEvent -> checkInsight(mainScene));
//    	insightContainer.getChildren().add(doneButton);
//		
//		Scene insightScene = new Scene(insightContainer);
//		applicationStage.setScene(insightScene);
//	}
}