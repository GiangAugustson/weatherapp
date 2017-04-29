package displayscreen;

import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.net.URL;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.fxml.*;

public class DisplayScreenController{
    @FXML private Label CityEntry;
    @FXML private Label DescriptionEntry;
    @FXML private Label WindSpeed;
    @FXML private Label Humidity;
    @FXML private Label MaxTemp;
    @FXML private Label CurrentTemp;
    @FXML private Label MinTemp;
    @FXML private Button SetLocation;
    
    //Initialize weather object
    weather w = new weather("Laurel");
    
    //Set defualt values for display screen using Laurel, MD
    public void initialize(){
        CityEntry.setText(w.getCity());
        DescriptionEntry.setText(w.getDescription());
        WindSpeed.setText(w.getWindSpeed() + " mph");
        Humidity.setText(w.getHumidity() + "%");
        MaxTemp.setText(w.getTempMax() + " °F");
        CurrentTemp.setText(w.getTemp() + " °F");
        MinTemp.setText(w.getTempMin() + " °F");
    }
    
    //Opens screen to edit location
    @FXML public void openEditScreen(ActionEvent event){
        try{
            URL url = getClass( ).getResource( "UpdateLocation.xml" );
            HBox root = FXMLLoader.load( url );
            Scene scene = new Scene(root, 600, 200);
            Stage stage = new Stage( );
            stage.setScene( scene );
            stage.setTitle( "Edit Location" );
            stage.show( );
        }
        catch( Exception e )  {
            e.printStackTrace();
        }
    }
    
    //Method to call when location is changed to update new values
    public void updateValues(){
        CityEntry.setText(w.getCity());
        DescriptionEntry.setText(w.getDescription());
        WindSpeed.setText(w.getWindSpeed() + " mph");
        Humidity.setText(w.getHumidity() + "%");
        MaxTemp.setText(w.getTempMax() + " °F");
        CurrentTemp.setText(w.getTemp() + " °F");
        MinTemp.setText(w.getTempMin() + " °F");
    }
}