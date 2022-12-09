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

/**
 * BudgetAppController class connects with other Controller classes redirect
 * to other scenes through every button.
 * 
 * @author Henry Pham & Naomi Phan
 *
 */
public class BudgetAppController {
	//Create instance variables pertaining to the GUI
	private Stage primaryStage;
	private Scene myScene;
	
	//Create instance variables of other Controllers' instances
	private IncomeController incomeSceneController;
	private SavingsController savingSceneController;
	private ExpensesController expensesSceneController;
	private InsightController insightSceneController;
	
	//Create instance variables of type double
	private double totalExpenses;
	private double totalSavings;
	private double totalIncome;
	
	//Import variable names from FXML file
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
	 * This method sets the value of monthlyIncomeLabel to incomeStr
	 * 
	 * @param incomeStr Parameter of typer String
	 */
	public void setMonthlyIncomeLabels(String incomeStr) {
		monthlyIncomeLabel.setText(incomeStr);
	}
	
	/**
	 * This method sets the value of monthlySavingsLabel to savingsStr
	 * 
	 * @param SavingsStr Parameter of typer String
	 */
	public void setMonthlySavingsLabels(String savingsStr) {
		monthlySavingsLabel.setText(savingsStr);
	}
	
	/**
	 * This method sets the value of monthlyExpensesLabel to expensesStr
	 * 
	 * @param expensesStr Parameter of type String
	 */
	public void setMonthlyExpensesLabels(String expensesStr) {
		monthlyExpensesLabel.setText(expensesStr);
	}
	
	/**
	 * This method sets the value of errorIncomeLabel to str
	 * 
	 * @param str Parameter of type String
	 */
	public void setErrorIncomeLabels(String str) {
		errorIncomeLabel.setText(str);
	}
	
	/**
	 * This method sets the value of errorSavingsLabel to str
	 * 
	 * @param str Parameter of type String
	 */
	public void setErrorSavingsLabels(String str) {
		errorSavingsLabel.setText(str);
	}
	
	/**
	 * This method sets the value of errorExpensesLabel to str
	 * 
	 * @param str Parameter of type String
	 */
	public void setErrorExpensesLabels(String str) {
		errorExpensesLabel.setText(str);
	}
	
	/**
	 * This method sets the value of totalIncome to incomeValue
	 * 
	 * @param incomeValue Parameter of type double
	 */
	public void setIncomeValue(double incomeValue) {
		totalIncome = incomeValue;		
	}
	
	/**
	 * This method sets the value of totalSavings to savingsaValue
	 * 
	 * @param savingsValue Parameter of type double
	 */
	public void setSavingsValue(double savingsValue) {
		totalSavings = savingsValue;		
	}	
	
	/**
	 * This method sets the value of totalExpenses to expensesValue
	 * 
	 * @param expensesValue Parameter of type double
	 */
	public void setExpensesValue(double expensesValue) {
		totalExpenses = expensesValue;		
	}
	
	@FXML
	/**
	 * This method directs user to a new scene of class IncomeController 
	 * 
	 * @param event Parameter of type ActionEvent
	 */
	public void getIncome(ActionEvent event) {
		if(incomeSceneController == null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				//Set FXML file to loader
				Parent root = loader.load(new FileInputStream("src/application/IncomeControllerView.fxml"));
				
				//Set variable incomeSceneController value to the Controller belong to the FXML file
				incomeSceneController = loader.getController();
				//Set stage for Controller
				incomeSceneController.setPrimaryStage(primaryStage);
				//Set scene for Controller
				incomeSceneController.setMyScene(new Scene(root));
				//Set this stage to be the next Controller
				incomeSceneController.setNextController(this);
				//Set error label to empty
				incomeSceneController.setErrorLabel("");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		//Set current user interface to IncomeController's user interface
		incomeSceneController.takeFocus();
	}
	
	@FXML
	/**
	 * This method directs user to a new scene of class SavingsController
	 * 
	 * @param event Parameter of type ActionEvent
	 */
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
	/**
	 * This method directs user to a new scene of class ExpensesController
	 * 
	 * @param event Parameter of type ActionEvent
	 */
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
	/**
	 * This method directs user to a new scene of class InsightController
	 * 
	 * @param event Parameter of type ActionEvent
	 */
	public void insightChecker(ActionEvent event) {
		if(insightSceneController == null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(new FileInputStream("src/application/InsightControllerView.fxml"));
				
				insightSceneController = loader.getController();
				insightSceneController.setPrimaryStage(primaryStage);
				insightSceneController.setMyScene(new Scene(root));
				//Set values totalIncome and totalExpenses to appropriate fields in the method
				insightSceneController.setNetIncomeLabels(totalIncome, totalExpenses);
				//Set value totalSavings and totalExpenses to appropriate fields in the method
				insightSceneController.setBudgetDifference(totalSavings, totalExpenses);				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		insightSceneController.takeFocus();
	}
}