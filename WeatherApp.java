package weatherApp;

import javafx.application.*;
import java.net.URL;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.fxml.*;

public class WeatherApp extends Application{
    @Override
    public void start(Stage stage){
        try{
            URL url = getClass().getResource("UpdateLocation.xml");
            AnchorPane root = FXMLLoader.load(url);
            Scene scene = new Scene(root, 300, 300);
            stage.setScene(scene);
            stage.setTitle("Update Location");
            stage.show();
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}