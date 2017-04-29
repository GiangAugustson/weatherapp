package displayscreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 *
 * This is the controller class for changing location/saving the new chosen location
 * @author Giang To
 *
 */
public class WeatherController {
	@FXML private TextField city;
	@FXML private TextField state;
	@FXML private Button save;

	/**
	 * This method handles the Save location button
	 */
	@FXML protected void handleButton (ActionEvent event) {
		try {

			if (event.getSource() == save) {

				WeatherAppSelector.save();
			}

		}
		catch (Exception e) {

		}
	}
}
