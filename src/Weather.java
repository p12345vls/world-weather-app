
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Gets the results from the openweathermap.org API.
 */
public class Weather {


	/**
	 * Constructor
	 *
	 * @param city
	 *            the city
	 * @param country
	 *            the country
	 */
	public Weather(String city, String country) {

		String query = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country + "&units=imperial"
				+ "&APPID=5e9299b7b275d2e3ed428b8575b3a3c5";

		String result = "";

		try {
			URL urlWeather = new URL(query);

			HttpURLConnection httpURLConnection = (HttpURLConnection) urlWeather.openConnection();

			if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

				InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
				try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 8192)) {
					String line = null;
					while ((line = bufferedReader.readLine()) != null) {
						result += line;
					}
				}

				parseResult(result);

			} else {
				System.out.println("Error in httpURLConnection.getResponseCode()");
			}

		} catch (MalformedURLException ex) {
			Logger.getLogger(Weather.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException | JSONException ex) {
			Logger.getLogger(Weather.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	/**
	 * Parses the result.
	 *
	 * @param json
	 *            the json
	 * @throws JSONException
	 *             the JSON exception
	 */
	private void parseResult(String json) throws JSONException {

		JSONObject jsonObject = new JSONObject(json);

		JSONObject coordinObj = jsonObject.getJSONObject("coord");
		Double longResult = coordinObj.getDouble("lon");
		Double latitResult = coordinObj.getDouble("lat");

		String countryResult;
		JSONObject sysObj = jsonObject.getJSONObject("sys");
		countryResult = sysObj.getString("country");

		String cloudsDescription = "";
		String iconResult = "";

		JSONArray weatherArray = jsonObject.getJSONArray("weather");
		if (weatherArray.length() > 0) {
			JSONObject weatherObj = weatherArray.getJSONObject(0);
			weatherObj.getInt("id");
			cloudsDescription = weatherObj.getString("description");
			iconResult = weatherObj.getString("icon");
		} else {
		}

		JSONObject jMain = jsonObject.getJSONObject("main");
		Double temperature = jMain.getDouble("temp");
		Double pressure = jMain.getDouble("pressure");
		Double humidity = jMain.getDouble("humidity");

		JSONObject jWind = jsonObject.getJSONObject("wind");
		Double windSpeed = jWind.getDouble("speed");
		String wind = windSpeed + "MPH ";

		jsonObject.getJSONObject("clouds");
		
		int dateResults = jsonObject.getInt("dt");
		String name = jsonObject.getString("name");
		String time = toDate(dateResults);

		setData(temperature.toString(), humidity.toString(), pressure.toString(), wind, time,
				name + "/" + countryResult, cloudsDescription, longResult.toString(), latitResult.toString(),
				iconResult);

	}

	/**
	 * @param timestamp
	 *            the timestamp
	 * @return the current time
	 */
	public static String toDate(int timestamp) {

		Date dt = new Date(timestamp * 1000l);

		SimpleDateFormat sfd = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		sfd.setTimeZone(TimeZone.getTimeZone("US/Pacific")); 
		return sfd.format(dt);
	}

	/**
	 * Sets the data .
	 *
	 * @param temperature
	 *            the temperature
	 * @param humidity
	 *            the humidity
	 * @param pressure
	 *            the pressure
	 * @param wind
	 *            the wind
	 * @param time
	 *            the time
	 * @param name
	 *            the name
	 * @param cloudsDescription
	 *            the clouds description
	 * @param lon
	 *            the longitude
	 * @param lat
	 *            the latitude
	 * @param icon
	 *            the corresponding weather icon
	 */
	public static void setData(String temperature, String humidity, String pressure, String wind, String time,
			String name, String cloudsDescription, String lon, String lat, String icon) {

		MapClass.tempResult.setText(temperature + " F");
		MapClass.skyResult.setText(cloudsDescription);
		MapClass.timeResult.setText(time);
		MapClass.windResult.setText(wind);
		MapClass.pressResult.setText(pressure + " kPa");
		MapClass.humidResult.setText(humidity + " %");
		MapClass.nameResult.setText(name);
		MapClass.imgLabel.setIcon(new ImageIcon("src/images/" + icon + ".png"));

	}
}
