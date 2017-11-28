package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * 
 * @author pdiez
 * @version 1.0.0
 * @see Main
 *
 */
public class Controller implements Initializable {

	@FXML
	private AnchorPane pane1;
	
	@FXML
	private JFXCheckBox p1c1, p1c2, p1c3;
	@FXML
	private JFXCheckBox p2c1, p2c2, p2c3;

	@FXML
	private AnchorPane pane2;

	@FXML
	private AnchorPane pane3;

	@FXML
	private Label countLabel, lblResultado;
	
	@FXML
	private JFXButton btnNext, btnBack;
	
	@FXML
	private Button btnComprobar;
	
	@FXML
	private ImageView imgResultado;
	


	public void translateAnimation(double duration, Node node, double byX) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		p1c1.setStyle("-fx-background-image: url(\"/application/house1.jpg\"); -fx-background-size: cover");
		p1c2.setStyle("-fx-background-image: url(\"/application/house2.jpg\"); -fx-background-size: cover");
		p1c3.setStyle("-fx-background-image: url(\"/application/house3.jpg\"); -fx-background-size: cover");
		
		p2c1.setStyle("-fx-background-image: url(\"/application/car1.jpg\"); -fx-background-size: cover");
		p2c2.setStyle("-fx-background-image: url(\"/application/car2.jpg\"); -fx-background-size: cover");
		p2c3.setStyle("-fx-background-image: url(\"/application/car3.jpg\"); -fx-background-size: cover");
		
		btnComprobar.setId("big-yellow");
		
		
		
		translateAnimation(0.5, pane2, 600);
		translateAnimation(0.5, pane3, 600);
		btnBack.setVisible(false);
		
		
	}

	int showSlide = 0;
	
	

	@FXML
	void nextAction(ActionEvent event) {

		if (showSlide == 0) {
			translateAnimation(0.5, pane2, -600);
			showSlide++; // showSlide=1
			countLabel.setText("2/3");
			btnBack.setVisible(true);
		} else if (showSlide == 1) {

			translateAnimation(0.5, pane3, -600);
			showSlide++; // showSlide=2
			countLabel.setText("3/3");
			btnNext.setVisible(false);

		} else {
			System.out.println("No more slides");
		}

	}

	@FXML
	void backAction(ActionEvent event) {

		if (showSlide == 0) {
			System.out.println("No more slide");
		} else if (showSlide == 1) {
			translateAnimation(0.5, pane2, 600);
			showSlide--; // showSlide=0
			countLabel.setText("1/3");
			btnBack.setVisible(false);
		} else if (showSlide == 2) {
			translateAnimation(0.5, pane3, 600);
			showSlide--; // showSlide=1
			countLabel.setText("2/3");
			btnNext.setVisible(true);
		}

	}
	
	@FXML
	void exitButton(ActionEvent event) {
		Platform.exit();
	}
	
	@FXML
	void testResults(ActionEvent event) {
		boolean resultado = p1c1.isSelected() && !p1c2.isSelected() && p1c3.isSelected();
		resultado = resultado && !p2c1.isSelected() && !p2c2.isSelected() && p2c3.isSelected();

		if (resultado) {
			lblResultado.setText("¡CORRECTO!");
			imgResultado.setImage(new Image("/application/002-check.png"));
			pane3.setStyle("-fx-background-color:  #00b871;");
			
		} else {
			lblResultado.setText("¡FALLASTE!");
			imgResultado.setImage(new Image("/application/001-close.png"));
			pane3.setStyle("-fx-background-color:  #ff5e5e;");
		}
		imgResultado.setVisible(true);
		btnComprobar.setVisible(false);
		lblResultado.setVisible(true);
	}

}
