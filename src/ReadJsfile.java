import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Reads the JSON File with all the entries
 */
public class ReadJsfile {

	/** The index of the array. */
	static int index = 0;

	/** checks for a match in user search */
	static boolean foundMatch = false;
	/**
	 * The array of weather.
	 */
	private static WeatherResults[] arrayOfweather;

	/**
	 * Gets the search results.
	 *
	 * @param userCity
	 *            the user city
	 * @param userCountry
	 *            the user country
	 * @return the search results
	 */
	public static String[] getSearchResults(String userCity, String userCountry) {

		String searchResults[] = new String[4];
		WeatherResults[] w = getArrayOfWeather();

		Arrays.sort(w);
		try {
			for (WeatherResults w1 : w) {
				if (w1.getCity().equalsIgnoreCase(userCity) && w1.getCountry().equalsIgnoreCase(userCountry)) {
					foundMatch = true;
					MainClass.btn1.setVisible(foundMatch);
					searchResults[0] = w1.getCountry();
					searchResults[1] = w1.getCity();
					searchResults[2] = w1.getLatitude();
					searchResults[3] = w1.getLongtidute();

				}
			}
		} catch (NullPointerException e) {

		}

		return searchResults;
	}

	/**
	 * @param jsonFilePath
	 *            the json file path
	 */
	public ReadJsfile(String jsonFilePath) {

		try {

			FileReader fileReader = new FileReader(jsonFilePath);

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

			JSONArray weatherArray = (JSONArray) jsonObject.get("weather");

			arrayOfweather = new WeatherResults[weatherArray.size()];
			Iterator<?> iterator = weatherArray.iterator();

			while (iterator.hasNext()) {
				JSONObject currentJson = (JSONObject) iterator.next();

				String name = currentJson.get("name").toString();
				String country = currentJson.get("country").toString();
				Object lon = currentJson.get("lon");
				Object lat = currentJson.get("lat");

				WeatherResults w = new WeatherResults(name, country, lon.toString(), lat.toString());
				arrayOfweather[index++] = w;

			}
		} catch (FileNotFoundException e) {
		} catch (IOException | ParseException e) {
		}

	}

	/**
	 * returns the array of Weather entries.
	 *
	 * @return the array of Weather
	 */
	public static WeatherResults[] getArrayOfWeather() {
		return arrayOfweather;
	}

	/**
	 * displays the array of Weather entries for debugging purposes
	 */
	public void printAllData() {
		for (WeatherResults weather : arrayOfweather) {
			System.out.println(weather);
		}
	}

}
