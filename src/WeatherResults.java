/**
 * Defines the values that will be displayed on the map panel.
 */
public class WeatherResults implements Comparable<WeatherResults> {
	
	/** The latitude. */
	private String city, country, longtidute, latitude;
	
	/** The Constant DEFAULT_CITY. */
	public static final String DEFAULT_CITY = "Blank";
	
	/** The Constant DEFAULT_COUNTRY. */
	public static final String DEFAULT_COUNTRY = "Blank";
	
	/** The Constant DEFAULT_LONGT. */
	public static final String DEFAULT_LONGT = "Blank";
	
	/** The Constant DEFAULT_LATIT. */
	public static final String DEFAULT_LATIT = "Blank";

	/**
	 * Instantiates a new weather results.
	 */
	public WeatherResults() {
		this(DEFAULT_CITY, DEFAULT_COUNTRY, DEFAULT_LONGT, DEFAULT_LATIT);
	}

	/**
	 * Instantiates a new weather results.
	 *
	 * @param city the city
	 * @param country the country
	 * @param longtidute the longtidute
	 * @param latitude the latitude
	 */
	public WeatherResults(String city, String country, String longtidute, String latitude) {
		this.city = city;
		this.country = country;
		this.longtidute = longtidute;
		this.latitude = latitude;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Gets the longtidute.
	 *
	 * @return the longtidute
	 */
	public String getLongtidute() {
		return longtidute;
	}

	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WeatherResults{" + "city=" + city + ", country=" + country + ", longtidute=" + longtidute
				+ ", latitude=" + latitude + '}';
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(WeatherResults o) {
		return this.getCity().compareTo(o.getCity());

	}

}