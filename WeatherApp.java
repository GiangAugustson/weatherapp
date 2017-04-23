package weatherApp;

import java.net.URL;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

/**
 *
 * This is the main class of the Weather App GUI program
 * @author Giang To
 *
 */
public class WeatherApp extends Application {
	@Override
	public void start(Stage stage) {
		try {
			URL url = getClass().getResource("UpdateLocation.xml");
			HBox root = FXMLLoader.load(url);
			Scene scene = new Scene(root, 600, 200);
			stage.setTitle("Weather App");
			stage.setScene(scene);

			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
