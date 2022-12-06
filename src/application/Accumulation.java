package application;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class Accumulation extends Budget{

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
    	activityList.add("Miscenllaneous");
    	activityList.add("Shopping");
    	activityList.add("Household Necessities");
    	activityList.add("Other");
    	
    	TextField aTextField = new TextField();
		BorderPane aBorderPane = new BorderPane();

		TextFields.add(aTextField);
		aBorderPane.setLeft(activityChoiceBox);
		aBorderPane.setRight(aTextField);		
		return aBorderPane;
	}
	
	public static BorderPane generateDate() {
		DatePicker addDate = new DatePicker();
		BorderPane newDate = new BorderPane();
		addDate.getEditor().setDisable(true);
		newDate.setLeft(addDate);
		return newDate;
	}
}
