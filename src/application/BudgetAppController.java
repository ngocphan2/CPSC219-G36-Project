package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	private InsightController insightSceneController;
	
	private double totalExpenses;
	private double totalSavings;
	private double totalIncome;
	
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
	
	public void setExpensesValue(Double expensesValue) {
		totalExpenses = expensesValue;		
	}	
	public void setSavingsValue(Double savingsValue) {
		totalSavings = savingsValue;		
	}	
	public void setIncomeValue(Double incomeValue) {
		totalIncome = incomeValue;		
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
				savingSceneController.setErrorLabel("Please have at least 1 entry");
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
				expensesSceneController.setErrorLabel("Please have at least 1 entry");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		expensesSceneController.takeFocus();
	}
	
	@FXML
	public void insightChecker(ActionEvent event) {
		if(insightSceneController == null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(new FileInputStream("src/application/InsightControllerView.fxml"));
				
				insightSceneController = loader.getController();
				insightSceneController.setPrimaryStage(primaryStage);
				insightSceneController.setMyScene(new Scene(root));
				insightSceneController.setNextController(this);
				insightSceneController.setNetIncomeLabels(totalIncome, totalExpenses);
				insightSceneController.setBudgetDifference(totalSavings, totalExpenses);
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		insightSceneController.takeFocus();
	}
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