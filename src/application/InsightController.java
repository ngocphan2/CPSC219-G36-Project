package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InsightController {
	private Stage primaryStage;
	private Scene myScene;
	private BudgetAppController nextController;

	private double expenses = 0.0;
	private double savings = 0.0;
	private double budgetDifference = 0.0;
	private double income = 0.0;
	private double netIncome = 0.0;
	
	@FXML
	private VBox insightVBox;
	
	@FXML
	private Label overviewTitleLable;
	
	@FXML
	private Label netIncomeLabel;
	
	@FXML
	private Label netIncomeInsightLabel;
	
	@FXML
	private Label budgetTitleLabel;
	
	@FXML
	private Label budgetInsightLabel;
	
	@FXML
	private Label setExpensesLabel;
	
	@FXML
	private Label savingsPercentage;
	
	@FXML
	private Label savingsPercentageInsightLabel;
	
	@FXML
	private Label emergencyFund;
	
	public void setNetIncomeLabels(double income, double expenses) {
		this.income = income;
		this.expenses = expenses;
		netIncome = this.income - this.expenses;
		netIncomeLabel.setText("Net Income: " + netIncome);
		generateInsight(netIncome, netIncomeInsightLabel, "Net Income");
		double savingsPercent = netIncome/this.income * 100;
		savingsPercentage.setText("Savings Percentage: " + savingsPercent +"%");
		double emergencyFundValue = this.expenses * 6;
		emergencyFund.setText("Recommended Emergency Fund Value: " + emergencyFundValue);
		savingsPercentageInsight(savingsPercent, emergencyFundValue);

	}
	
	public void setBudgetDifference(double savings, double expenses) {
		this.savings = savings;
		this.expenses = expenses;
		budgetDifference = this.savings - this.expenses;
		budgetTitleLabel.setText("Budget vs. Actual: " + budgetDifference);
		generateInsight(budgetDifference, budgetInsightLabel, "Budget");
	}
	
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}	
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	public void setNextController(BudgetAppController next) {
		nextController = next;
	}
	
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}
	
	public void goToController(ActionEvent event) {
		nextController.takeFocus();
	}
	
	public void generateInsight(double value, Label label, String name) {
		if (value > 0) {
			label.setText(name + " is at surplus by $" + value);
		}
		if (value < 0) {
			label.setText(name + " is at deficit by $" + value + ".\n "
					+ "You should reduce expenses. ");
		}
		if (value == 0) label.setText(name + " is at $" + value);
	}
	
	public void savingsPercentageInsight(double value, double emergencyFund) {
		double half = value/2;
		if (value >= 20) {
			savingsPercentageInsightLabel.setText("You met the saving recommendation \n"
					+ "For future financial independence, you should put aside " + half
					+ "% sd emergency fund until it reaches " + emergencyFund + ". Also, invest " + half + "in GIC/stocks/bonds/ETFs, \n"
					+ "depending on your risk tolerance.");
		}
		else if (value < 20 && value > 0) {
			savingsPercentageInsightLabel.setText("Your saving percentage is below the recommendation. \n"
					+ "You should put all the savings asign for emergency fund until it reaches " 
					+ emergencyFund + ". Then, you can invest your savings to earn compounded interest.");
		}
		else {
			savingsPercentageInsightLabel.setText("");
		}
	}	
}
