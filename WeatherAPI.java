package weatherApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.*;

/**
 *
 * @authors Alex Pratte, Giang To, Steven Rodo, James Oliver
 */

public class WeatherAPI {

    private String city;
    private String description;
    private double temp;
    private double tempMax;
    private double tempMin;
    private double windSpeed;
    private int humidity;

    //api key
    private final String appID = "0fd8cddc2afe50a6772a36c08dc28714";

    public WeatherAPI(String city) {
        try {
            //make connection
            URL test = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + ",us&appid=" + appID);
            InputStream in = test.openConnection().getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            //fill the string buffer
            Scanner scan = new Scanner(in);
            String buff = "";
            while (scan.hasNext()) {
                buff += scan.next();
            }
            System.out.println(buff);
            // create new JSONObject with JSON buffer
            JSONObject obj = new JSONObject(buff);
            //set fields
            setCity(city);

            int humidity = (Integer) obj.getJSONObject("main").get("humidity");
            setHumidity(humidity);
            double temp = (Double) obj.getJSONObject("main").get("temp");
            setTemp(getFahrenheit(temp));
            double tempMin = (Double) obj.getJSONObject("main").get("temp_min");
            setTempMin(getFahrenheit(tempMin));
            double tempMax = (Double) obj.getJSONObject("main").get("temp_max");
            setTempMax(getFahrenheit(tempMax));
            setDescription((String) obj.getJSONArray("weather").getJSONObject(0).getString("description"));
            //catch exceptions
        } catch (MalformedURLException ex) {
            System.err.println("bad URL");
        } catch (IOException ex) {
            System.err.println("IO exception");

        } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    //the temperature in the API is Kelvin so convert to Fahrenheit
    private double getFahrenheit(double degreesKelvin) {
        double f = (((degreesKelvin - 273) * 9 / 5) + 32);
        return round(f, 2);
    }
    private double getCelsius(double degreesKelvin) {
        return round((degreesKelvin - 273), 2);
    }

    //rounding
    private double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}