package application;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Accumulation class is a sub-class of Budget class.
 * Allows other classes to generate instances and call for methods.
 * 
 * @author Henry Pham & Naomi Phan
 *
 */
public class Accumulation extends Budget{	
	/**
	 * This constructor calls for the same constructor with one parameter of type double
	 * from Budget class.
	 * 
	 * @param value Parameter of typer double
	 */
	public Accumulation(double value) {
		super(value);
	}
	
	/**
	 * This constructor calls for the same constructor with one parameter of type String
	 * and throws the same error from Budget class.
	 * 
	 * @param str Parameter of type String
	 * @throws InvalidBudgetException On input error from InvalidBudgetException class
	 */
	public Accumulation(String str) throws InvalidBudgetException{
		super(str);
	}
	
	/**
	 * This method takes in an ArrayList<TextField> and create a ChoiceBox<String> along with
	 * new TextField and BorderPane.
	 * 
	 * @param TextFields Parameter of type ArrayList<TextField>
	 * @return BorderPane This returns a BorderPane containing a ChoiceBox and TextField
	 */
	public static BorderPane generateTextField(ArrayList<TextField> TextFields) {
		//Create new ChoiceBox<String> named activityChoiceBox
		ChoiceBox<String> activityChoiceBox = new ChoiceBox<String>();
		//Create new ObservableLsit<String> that takes get items from activityChoiceBox
    	ObservableList<String> activityList = activityChoiceBox.getItems();
    	
    	//Set initial text for activityChoiceBox
    	activityChoiceBox.setValue("Other");

    	//Add items for activityChoiceBox
    	activityList.add("Rent/Mortgage");
    	activityList.add("Car Payment");
    	activityList.add("Car Insurance");
    	activityList.add("Health Insurance");
    	activityList.add("Other Insurance");
    	activityList.add("Food");
    	activityList.add("Utility");
    	activityList.add("Phone Bill");
    	activityList.add("Other");
    	
    	//Create new objects
    	TextField aTextField = new TextField();
		BorderPane aBorderPane = new BorderPane();

		//Add created TextField named aTextField to ArrayList<TextField> TextFields
		TextFields.add(aTextField);
		//Set positions of objects within BorderPane
		aBorderPane.setLeft(activityChoiceBox);
		aBorderPane.setRight(aTextField);		
		return aBorderPane;
	}
		
	/**
	 * This method removes any existed TextField within the VBox inserted.
	 * 
	 * @param container First parameter to removeTextField
	 * @param pos Second parameter to removeTextField
	 * @param TextFields Third parameter to removeTextField
	 */
	public static void removeTextField(VBox container, int pos, ArrayList<TextField> TextFields) {
		if (TextFields.size() > 0)	TextFields.remove(TextFields.size() - 1);
		container.getChildren().remove(pos);
	}
}
