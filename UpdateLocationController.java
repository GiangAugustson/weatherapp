package weatherApp;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * This is the controller class for changing location/saving the new chosen location
 * @author Giang To
 *
 */
public class UpdateLocationController {
	@FXML private TextField city;
	@FXML private Button display;
	private static String location;

	@FXML protected void getCity(ActionEvent event) {
		try {
			location = city.getText();
			//DOESN'T TAKE IN THIS INPUT AS EXPECTED
		}
		catch (Exception e) {
			city.setText("invalid");
		}
	}

	public static String getLocation() {
		return location;
	}

	/**
	 * This method handles the Save location button
	 */
	@FXML protected void displayWeather (ActionEvent event) {
		try {
			URL url = getClass().getResource("DisplayWeather.xml");
			AnchorPane root = FXMLLoader.load( url );
            Scene scene = new Scene(root, 300, 300);
            Stage stage = new Stage( );
            stage.setScene( scene );
            stage.setTitle( "Weather App" );
            stage.show( );
		}
		catch (Exception e) {

		}
	}
}
