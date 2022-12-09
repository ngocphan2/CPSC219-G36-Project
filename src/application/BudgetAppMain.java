package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

/**
 * BudgetAppMain class enables other classes to run and set primary scene for GUI.
 * 
 * @author Henry Pham & Naomi Phan
 *
 */
public class BudgetAppMain extends Application {
	@Override
	/**
	 * This method simply sets the primary user interface for the application. 
	 * 
	 * @param primaryStage Parameter of type Stage to start method 
	 */
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/BudgetAppView.fxml"));
			
			Scene scene = new Scene(root,200,280);

			BudgetAppController controller = (BudgetAppController)loader.getController();
			controller.setPrimaryStage(primaryStage);
			controller.setMyScene(scene);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Budget Application");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Auto-generated class
	 * 
	 * @param args Unused
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
