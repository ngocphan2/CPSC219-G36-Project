package application;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class Accumulation extends Budget{
	private double rent;
	private double carPayment;
	private double carInsurance;
	private double healthInsurance;
	private double otherInsurance;
	private double food;
	private double utility;
	private double phonePlan;
	private double other;
		
	public Accumulation(double value) {
		super(value);
	}
	
	public Accumulation(String str) throws InvalidBudgetException{
		super(str);
	}
	
	public static BorderPane generateTextField(ArrayList<TextField> TextFields) {
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
    	activityList.add("Other");
    	
    	TextField aTextField = new TextField();
		BorderPane aBorderPane = new BorderPane();

		TextFields.add(aTextField);
		aBorderPane.setLeft(activityChoiceBox);
		aBorderPane.setRight(aTextField);		
		return aBorderPane;
	}
	
	public void addChoiceBox(ChoiceBox<String> activityChoiceBox, Accumulation myAccumulation,
			ArrayList<Double> activityList) {		
		if (activityChoiceBox.getValue() == "Rent/Mortgage") {
			rent += myAccumulation.getValue();
		}
		else if (activityChoiceBox.getValue() == "Car Payment") {
			carPayment += myAccumulation.getValue();
		}
		else if (activityChoiceBox.getValue() == "Car Insurance") {
			carInsurance += myAccumulation.getValue();
		}
		else if (activityChoiceBox.getValue() == "Health Insurance") {
			healthInsurance += myAccumulation.getValue();
		}
		else if (activityChoiceBox.getValue() == "Other Insurance") {
			otherInsurance += myAccumulation.getValue();
		}
		else if (activityChoiceBox.getValue() == "Food") {
			food += myAccumulation.getValue();
		}
		else if (activityChoiceBox.getValue() == "Utility") {
			utility += myAccumulation.getValue();
		}
		else if (activityChoiceBox.getValue() == "Phone Plan") {
			phonePlan += myAccumulation.getValue();
		} else {
			other += myAccumulation.getValue();
		}		
		activityList.add(rent);
		activityList.add(carPayment);
		activityList.add(carInsurance);
		activityList.add(healthInsurance);
		activityList.add(otherInsurance);
		activityList.add(food);
		activityList.add(utility);
		activityList.add(phonePlan);
		activityList.add(other);
	}
		
	public static BorderPane generateDate() {
		DatePicker addDate = new DatePicker();
		BorderPane newDate = new BorderPane();
		addDate.getEditor().setDisable(true);
		newDate.setLeft(addDate);
		return newDate;
	}
}
