package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * 
 * @author pdiez
 * @version 1.0.0
 * @see Controller
 *
 */

public class Main extends Application {
	Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			mainWindow();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void mainWindow() {
		try {

			FXMLLoader loader=new FXMLLoader(getClass().getResource("ventana.fxml"));
	        AnchorPane pane=loader.load();
	        stage.initStyle(StageStyle.UNDECORATED);
	        stage.setScene(new Scene(pane));
	        stage.getScene().getStylesheets().add("/application/javafx.css");
	        stage.show();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
