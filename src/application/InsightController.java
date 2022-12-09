package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * InsightController class generates data input by the user from other 3 controller
 * classes, then provide recommendation based on those data
 * 
 * @author Henry Pham & Naomi Phan
 *
 */
public class InsightController {
	//Declare instance variables pertaining to the GUI
	private Stage primaryStage;
	private Scene myScene;
	
	//Declare instance variables pertaining to user's data input
	private double expenses;
	private double savings;
	private double budgetDifference;
	private double income;
	private double netIncome;
	
	//Import variable names from FXML file
	@FXML
	private Label netIncomeLabel;
	
	@FXML
	private Label netIncomeInsightLabel;
	
	@FXML
	private Label budgetTitleLabel;
	
	@FXML
	private Label budgetInsightLabel;
	
	@FXML
	private Label savingsPercentage;
	
	@FXML
	private Label savingsPercentageInsightLabel;
	
	@FXML
	private Label savingsPercentageRecommendation;
	
	@FXML
	private Label emergencyFund;
	
	/**
	 * This method sets value of instance variable primaryStage
	 * 
	 * @param aStage Parameter of type Stage
	 */
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}	
	
	/**
	 * This method sets value of instance variable myScene
	 * 
	 * @param aScene Parameter of type Scene
	 */
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	
	/**
	 * This method set the scene of the user interface when called
	 */
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}
	
	/**
	 * This method closes the current scene and go back to the main Controller
	 * 
	 * @param event Parameter of type ActionEvent
	 */
	public void exitApp(ActionEvent event) {
		primaryStage.close();
	}
	
	/**
	 * This method calculates and displays net income, savings percentage, and the
	 * recommended value of emergency fund. It calls generateInsight and 
	 * savingsPercentageInsight to provide appropriate insight message. 
	 * It also provides recommendation related to the net income calculated.
	 * 
	 * @param income Parameter of type double
	 * @param expenses Parameter of type double
	 */
	public void setNetIncomeLabels(double income, double expenses) {
		this.income = income;
		this.expenses = expenses;
		netIncome = this.income - this.expenses;
		netIncomeLabel.setText("Net Income: $" + netIncome);
		generateInsight(netIncome, netIncomeInsightLabel, "Net Income");
		double savingsPercent = netIncome/this.income * 100;
		savingsPercentage.setText("Savings Percentage: " + String.format("%.2f", savingsPercent) +"%");
		double emergencyFundValue = this.expenses * 6;
		emergencyFund.setText("Recommended Emergency Fund Value: $" + String.format("%.2f", emergencyFundValue));
		savingsPercentageInsight(savingsPercent, emergencyFundValue);
		savingsPercentageRecommendation.setText("Professional financial advisors recommend that " 
		+ "the ideal savings percentage is 20%" + "\n" + "Also, everyone should build an "
		+ "emergency fund (ideally, 6 months of your expenses) to cover expenses" + "\n" 
		+ "in case you are not able to work for a period of time." + "\n");

	}
	
	/**
	 * This method calculates and displays the difference between budgeted spending and actual spending 
	 * of the month. It calls generateInsight to displays the appropriate message for the budget 
	 * difference calculated
	 * 
	 * @param savings Parameter of type double
	 * @param expenses Parameter of type double
	 */
	public void setBudgetDifference(double savings, double expenses) {
		this.savings = savings;
		this.expenses = expenses;
		budgetDifference = this.savings - this.expenses;
		budgetTitleLabel.setText("Budget vs. Actual Spendings: $" + String.format("%.2f", budgetDifference));
		generateInsight(budgetDifference, budgetInsightLabel, "Budget");
	}
	
	/**
	 * This method sets an appropriate insight message for the value calculated.
	 * 
	 * @param value Parameter of type double
	 * @param label Parameter of type Label
	 * @param name Parameter of type String
	 */
	public void generateInsight(double value, Label label, String name) {
		if (value > 0) {
			label.setText(name + " is at surplus by $" + String.format("%.2f", value));
		}
		if (value < 0) {
			label.setText(name + " is at deficit by $" + String.format("%.2f", value));
		}
		if (value == 0) label.setText(name + " is at $" + String.format("%.2f", value));
	}
	
	/**
	 * This method sets the appropriate insight message for the savings percentage calculated.
	 * 
	 * @param value Parameter of type double
	 * @param emergencyFund Parameter of type double
	 */
	public void savingsPercentageInsight(double value, double emergencyFund) {
		double half = value/2;
		if (value >= 20) {
			savingsPercentageInsightLabel.setText("You met the saving recommendation" + "\n"
					+ "For future financial independence, you should put aside half of your net income (" 
					+ String.format("%.2f", half) + "%) as emergency fund until it reaches $" 
					+ String.format("%.2f", emergencyFund) + "\n" 
					+ "You can invest the other half (" + String.format("%.2f", half) + "%) in GIC/stocks/bonds/ETFs, "
					+ "depending on your risk tolerance, to earn compounded interest over longterm.");
		}
		else if (value < 20 && value >= 0) {
			savingsPercentageInsightLabel.setText("Your saving percentage is below the recommendation. \n"
					+ "You should put all the savings asign for emergency fund until it reaches $" 
					+ String.format("%.2f", emergencyFund) + ". Then, you can invest your savings "
							+ "to earn compounded interest.");
		}
		else {
			savingsPercentageInsightLabel.setText("You have overspent this month. You should reduce expenses");
			savingsPercentageRecommendation.setText("");
			savingsPercentage.setText("");
		}
	}	
}
