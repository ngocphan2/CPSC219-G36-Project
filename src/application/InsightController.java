package application;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InsightController {
	private Stage primaryStage;
	private Scene myScene;
	private BudgetAppController nextController;
	
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
}
